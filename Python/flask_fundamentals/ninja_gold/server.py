from flask import Flask, session, request, redirect, render_template # Insert required functions.
import random
app = Flask(__name__)
app.secret_key = "Klaatu Barada Nikto"
@app.route('/')
def index():
    session['gold'] += 0
    if 'activities' not in session:
        session['activities'] = []
    return render_template("index.html", gold=session['gold'], activities=session['activities'])
@app.route('/process_gold', methods=["POST"])
def process():
    activity = request.form['activity']
    if activity == 'farm':
        earnings = random.randrange(10,21)
        session['activities'].append("Earned {} gold from the farm!\n".format(earnings))
        session['gold'] += earnings
    elif activity == 'cave':
        earnings = random.randrange(5,11)
        session['activities'].append("Earned {} gold from the cave!\n".format(earnings))
        session['gold'] += earnings
    elif activity == 'house':
        earnings = random.randrange(2,6)
        session['activities'].append("Earned {} gold from the house!\n".format(earnings))
        session['gold'] += earnings
    elif activity == 'casino':
        earnings = random.randrange(-50,51)
        if earnings > 0:
            session['activities'].append("Won {} gold at the casino!\n".format(earnings))
        elif earnings < 0:
            session['activities'].append("Lost {} gold at the casino...\n".format(earnings*-1))
        else:
            session['activities'].append("Broke even at the casino.")
        session['gold'] += earnings
    return redirect('/')
app.run(debug=True)