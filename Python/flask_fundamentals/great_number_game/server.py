from flask import Flask, render_template, session, redirect, request
import random
app = Flask(__name__)
app.secret_key="KlaatuBaradaNikto"
@app.route('/')
def index():
    if 'answer' not in session:
        session['answer'] = random.randrange(1,101)
    if 'guess' not in session:
        session['guess'] = 0
    return render_template("index.html", userguess=session['guess'], answer=session['answer'])
@app.route('/guess', methods=["POST"])
def guess():
    session['guess'] = int(request.form['guess'])
    return redirect('/')
@app.route('/reset', methods=["POST"])
def reset():
    session['answer'] = random.randrange(1,101)
    return redirect('/')
app.run(debug=True)