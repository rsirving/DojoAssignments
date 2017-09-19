from django.shortcuts import render, HttpResponse, redirect
import random

# Create your views here.
def index(request):
    if not "gold" in request.session:
        request.session["gold"] = 0
    if not "activities" in request.session:
        request.session["activities"] = []
    return render(request, "index.html")
def process_money(request):
    if request.method == "POST":
        activity = str(request.POST['activity'])
        if activity == 'farm':
            earnings = random.randrange(10,21)
            request.session['activities'].insert(0, "Earned {} gold from the farm!\n".format(earnings))
            request.session['gold'] += earnings
        elif activity == 'cave':
            earnings = random.randrange(5,11)
            request.session['activities'].insert(0, "Earned {} gold from the cave!\n".format(earnings))
            request.session['gold'] += earnings
        elif activity == 'house':
            earnings = random.randrange(2,6)
            request.session['activities'].insert(0, "Earned {} gold from the house!\n".format(earnings))
            request.session['gold'] += earnings
        elif activity == 'casino':
            if request.session["gold"] <= 0:
                request.session["activities"].insert(0, "You need gold to gamble at the casino!")
                earnings = 0
            else:
                earnings = random.randrange(-50,51)
                if (earnings * -1) > request.session["gold"]:
                    request.session['activities'].insert(0, "Lost all your gold at the casino!")
                    earnings = request.session["gold"] * -1
                elif earnings > 0:
                    request.session['activities'].insert(0, "Won {} gold at the casino!\n".format(earnings))
                elif earnings < 0:
                    request.session['activities'].insert(0, "Lost {} gold at the casino...\n".format(earnings*-1))
                else:
                    request.session['activities'].insert(0, "Broke even at the casino.")
            request.session['gold'] += earnings
        return redirect('/ninja_gold')
    else:
        return redirect('/ninja_gold')
def reset(request):
    del request.session["gold"]
    del request.session["activities"]
    return redirect('/ninja_gold')