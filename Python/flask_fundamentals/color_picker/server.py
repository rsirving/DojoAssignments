from flask import Flask, request, render_template, redirect
app = Flask(__name__)
@app.route('/')
def root():
    values = {'red':255, 'green':255, 'blue':255}
    return render_template('index.html', colors=values)

@app.route('/submit', methods=["POST"])
def submit():
    values = request.form
    return render_template('index.html', colors=values)

app.run(debug=True)