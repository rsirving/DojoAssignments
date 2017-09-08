from flask import Flask, request, render_template, redirect
app = Flask(__name__)
@app.route('/')
def root():
    return render_template('index.html')

@app.route('/results', methods=['POST'])
def results():
    return render_template("results.html", results=request.form)

app.run(debug=True)