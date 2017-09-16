from flask import Flask, render_template, session, request, redirect, flash # Insert required functions.
from mysqlconnection import MySQLConnector
import re, md5, os, binascii
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "Klaatu Barada Nikto"
mysql = MySQLConnector(app,'walldb')
@app.route('/')
def index():
    return render_template("index.html")
@app.route('/register', methods=["POST"])
def register():
    info = request.form
    errors = False
    for i in info:
        if len(info[i]) < 1:
            flash("All fields are required.")
            errors = True
            break
    if len(info['first_name']) < 2 or len(info['last_name']) < 2:
        flash("Names must be more than 2 characters long.")
        errors = True
    if any(char.isdigit() for char in info['first_name']):
        flash("Your name does not have a number in it. You're not a robot.")
        errors = True
    if any(char.isdigit() for char in info['last_name']):
        flash("Your name does not have a number in it. You're not a robot.")
        errors = True
    if not EMAIL_REGEX.match(info['email']):
        flash("Invalid Email Address.")
        errors = True
    if len(info['password']) >= 1 and len(info['password']) < 8:
        flash("Invalid password. Must be 8 characters or longer.")
        errors = True
    if info['password'] != info['password-confirm']:
        flash("Password and confirmation must match.")
        errors = True
    if not errors:
        flash("Thanks for registering!")
        salt = binascii.b2a_hex(os.urandom(15))
        query = "INSERT INTO users (first_name, last_name, email, password, salt, created_at, updated_at) VALUES (:first_name, :last_name, :email, :password, :salt, NOW(), NOW())"
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'email': request.form['email'],
            'password': md5.new(request.form['password'] + salt).hexdigest(),
            'salt': salt
        }
        mysql.query_db(query, data)
    return redirect('/')
@app.route('/login', methods=['post'])
def login():
    getUserQuery = 'SELECT * FROM users WHERE email = :email'
    getUserData = {'email': request.form['email']}
    user = mysql.query_db(getUserQuery, getUserData)
    if len(user) == 0:
        flash('User does not exist.')
        return redirect('/')
    password = md5.new(request.form['password'] + user[0]['salt']).hexdigest()
    if user[0]['password'] == password:
        session['user_id'] = user[0]['id']
        return redirect('/wall')
    flash ("Incorrect password.")
    return redirect('/')
@app.route('/wall')
def wall():
    if not 'user_id' in session:
        return redirect('/')
    messageQuery = "SELECT CONCAT(users.first_name, ' ', users.last_name) AS user_name, users.id AS user_id, messages.id AS message_id, messages.message AS message, DATE_FORMAT(messages.created_at, '%M %D, %Y') AS created_at FROM messages JOIN users ON users.id = messages.user_id"
    commentQuery = "SELECT CONCAT(users.first_name, ' ', users.last_name) AS user_name, users.id AS user_id, messages.id AS message_id, comments.id AS comment_id, comments.comment AS comment, DATE_FORMAT(comments.created_at, '%M %D, %Y') AS created_at FROM comments JOIN messages ON comments.message_id = messages.id JOIN users on messages.user_id = users.id"
    messages = mysql.query_db(messageQuery)
    comments = mysql.query_db(commentQuery)
    return render_template('wall.html', messages=messages, comments=comments)
@app.route('/message', methods=['post'])
def message():
    query = "INSERT INTO messages (user_id, message, created_at, updated_at) VALUES (:user_id, :message, NOW(), NOW())"
    data = {'user_id': session['user_id'], 'message': request.form['message']}
    mysql.query_db(query, data)
    return redirect('/wall')
@app.route('/comment', methods=['post'])
def comment():
    query = "INSERT INTO comments (user_id, message_id, comment, created_at, updated_at) VALUES (:user_id, :message_id, :comment, NOW(), NOW())"
    data = {'user_id': session['user_id'], 'message_id': request.form['message_id'], 'comment': request.form['comment']}
    mysql.query_db(query, data)
    return redirect('/wall')
@app.route('/logout', methods=['GET'])
def logout():
    session.clear()
    return redirect('/')
app.run(debug=True)