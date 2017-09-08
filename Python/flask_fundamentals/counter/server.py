from flask import Flask, session, render_template, redirect
app = Flask(__name__)
app.secret_key = "KlaatuBaradaNikto"
@app.route('/')
def root():
    session['count'] += 1
    return render_template("index.html", counter=session['count'])
@app.route('/plustwo')
def plustwo():
    session['count'] +=1
    return redirect('/')
@app.route('/reset')
def reset():
    session['count'] = 0
    return redirect('/')
app.run(debug=True)