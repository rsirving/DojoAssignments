from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
app = Flask(__name__)
app.secret_key = "Klaatu Barada Nikto"
mysql = MySQLConnector(app,'restful_friendsdb')

@app.route('/')
def route():
    return redirect('/users')

@app.route('/users')
def index():
    query = "SELECT id, CONCAT(fname,' ',lname) AS name, email, DATE_FORMAT('%M %D, %Y', created_at) AS created_at FROM users"
    users = mysql.query_db(query)
    return render_template('index.html', users=users)

@app.route('/users/new', methods=["GET"])
def new():
    return render_template('new_user.html')

@app.route('/users/<id>/edit', methods=["GET"])
def edit(id):
    query = "SELECT * FROM users WHERE id = :id"
    data = {'id': id}
    users = mysql.query_db(query, data)
    return render_template('edit.html', user=users[0])

@app.route('/users/<id>', methods=["GET"])
def show(id):
    query = "SELECT * FROM users WHERE id = :id"
    data = {'id': id}
    users = mysql.query_db(query, data)
    return render_template('single_user.html', user=users[0])

@app.route('/users/create', methods=["POST"])
def create():
    query = "INSERT INTO users (first_name, last_name, email, created_at) VALUES (:first_name, :last_name, :email, NOW())"
    data = {
             'first_name': request.form['first_name'],
             'last_name':  request.form['last_name'],
             'email': request.form['email']
           }
    mysql.query_db(query, data)
    return redirect('/users/<id>')

@app.route('/users/<id>/destroy', methods=["GET"])
def destroy(id):
    query = "DELETE FROM users WHERE id = :id"
    data = {'id': id}
    mysql.query_db(query, data)
    return redirect('/users')

@app.route('/users/<id>', methods=["POST"])
def update(id):
    query = "UPDATE users SET fname = :fname, lname = :lname, email = :email WHERE id = :id"
    data = {
        'fname': request.form['fname'],
        'lname': request.form['lname'],
        'email': request.form['email'],
        'id': id
    }
    mysql.query_db(query, data)
    return redirect('/users/<id>')

app.run(debug=True)