from flask import Flask, render_template, redirect
app = Flask(__name__)
@app.route('/')
def index():
  return render_template("index.html")
@app.route('/address')
def address():
    return render_template("address.html")
app.run(debug=True)