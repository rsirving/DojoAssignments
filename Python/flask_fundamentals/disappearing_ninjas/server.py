from flask import Flask, render_template, request, redirect
app = Flask(__name__)
@app.route('/')
def index():
  return render_template("index.html")

@app.route('/ninja')
def ninja():
    return render_template("ninja.html", turtle="all")
@app.route('/ninja/blue')
def leonardo():
    return render_template("ninja.html", turtle="blue")
@app.route('/ninja/purple')
def donatello():
    return render_template("ninja.html", turtle="purple")
@app.route('/ninja/orange')
def michelangelo():
    return render_template("ninja.html", turtle="orange")
@app.route('/ninja/red')
def raphael():
    return render_template("ninja.html", turtle="red")
@app.errorhandler(404)
def error(e):
    return render_template("ninja.html", turtle="april")
app.run(debug=True)