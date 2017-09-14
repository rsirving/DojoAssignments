from flask import Flask, request, redirect, render_template, session, flash
from mysqlconnection import MySQLConnector
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "Klaatu Barada Nikto"
mysql = MySQLConnector(app,'email')
@app.route('/')
def index():
    if 'error' not in session:
        session['error'] = False
    if session['error'] == True:
        flash("Invalid email address.")
        session['error'] = False
    return render_template('index.html')
@app.route('/submit', methods=['POST'])
def submit():
    info = request.form['address']
    if not EMAIL_REGEX.match(info):
        session['error'] = True
        return redirect('/')
    else:
        query = "INSERT INTO emails (address, date_created) VALUES (:address, NOW())"
        data = {
                 'address': request.form['address'],
            }
        mysql.query_db(query, data)
        return redirect('/success')
@app.route('/success')
def display():
    query = "SELECT * FROM emails"
    emails = mysql.query_db(query)
    return render_template('success.html', emails=emails)
# @app.route('/remove_friend/<friend_id>', methods=['POST'])
# def delete(friend_id):
#     query = "DELETE FROM friends WHERE id = :id"
#     data = {'id': friend_id}
#     mysql.query_db(query, data)
#     return redirect('/')
app.run(debug=True)