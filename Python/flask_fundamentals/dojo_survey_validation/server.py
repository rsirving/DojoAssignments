from flask import Flask, request, render_template, redirect, flash
app = Flask(__name__)
app.secret_key = "KlaatuBaradaNikto"
@app.route('/')
def root():
    return render_template('index.html')

@app.route('/results', methods=['POST'])
def results():
    if len(request.form['name']) < 1:
        flash("Please enter your name.")
    # Here is the conditional to make sure the comment is written, but I have commented it out because the comment is supposed to be optional.
    # if len(request.form['comment']) < 1:
    #     flash("Please enter your comment.")
    if len(request.form['comment']) > 120:
        flash("Comments must be 120 characters or less.")
    return render_template("results.html", results=request.form)
app.run(debug=True)