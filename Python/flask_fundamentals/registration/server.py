from flask import Flask, render_template, redirect, session, request, flash # Insert required functions.
import re
EMAIL_REGEX = re.compile(r'^[a-zA-Z0-9.+_-]+@[a-zA-Z0-9._-]+\.[a-zA-Z]+$')
app = Flask(__name__)
app.secret_key = "KlaatuBaradaNikto"
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
    if any(char.isdigit() for char in info['fname']):
        flash("Your name does not have a number in it. You're not a robot.")
        errors = True
    if any(char.isdigit() for char in info['lname']):
        flash("Your name does not have a number in it. You're not a robot.")
        errors = True
    if not EMAIL_REGEX.match(info['email']):
        flash("Invalid Email Address.")
        errors = True
    if len(info['password']) >= 1 and len(info['password']) < 8:
        flash("Invalid password. Must be 8 characters or longer.")
        errors = True
    if info['password'] != info['confirm']:
        flash("Password and confirmation must match.")
        errors = True
    if not errors:
        flash("Thanks for registering!")
    return redirect('/')
app.run(debug=True)

#X All fields are required and must not be blank
#X First and Last Name cannot contain any numbers
#X Password should be more than 8 characters
# Email should be a valid email
#X Password and Password Confirmation should match