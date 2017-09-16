from flask import Flask, render_template, session, request, redirect, flash # Insert required functions.
from mysqlconnection import MySQLConnector
import re, md5, os, binascii
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "Klaatu Barada Nikto"
mysql = MySQLConnector(app,'loginregdb')
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
    if not EMAIL_REGEX.match(info['address']):
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
        query = "INSERT INTO users (first_name, last_name, address, password, salt, time_created) VALUES (:first_name, :last_name, :address, :password, :salt, NOW())"
        data = {
            'first_name': request.form['first_name'],
            'last_name': request.form['last_name'],
            'address': request.form['address'],
            'password': md5.new(request.form['password'] + salt).hexdigest(),
            'salt': salt
        }
        mysql.query_db(query, data)
    return redirect('/')
@app.route('/login', methods=['post'])
def login():
    getUserQuery = 'SELECT * FROM users WHERE address = :address'
    getUserData = {'address': request.form['address']}
    user = mysql.query_db(getUserQuery, getUserData)
    if len(user) == 0:
        flash('User does not exist.')
        return redirect('/')
    password = md5.new(request.form['password'] + user[0]['salt']).hexdigest()
    if user[0]['password'] == password:
        session['user_id'] = user[0]['id']
        return redirect('/success')
    flash ("Incorrect password.")
    return redirect('/')
@app.route('/success')
def success():
    session.clear()
    if not 'user_id' in session:
        return redirect('/')
    query = "SELECT * FROM users WHERE id = :id"
    data = {'id': session['user_id']}
    users = mysql.query_db(query, data)
    return render_template('success.html')
@app.route('/logout')
def logout():
    session.clear()
    return redirect('/')
app.run(debug=True)