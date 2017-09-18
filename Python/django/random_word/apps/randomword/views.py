from django.shortcuts import render, HttpResponse, redirect
from django.utils.crypto import get_random_string

# Create your views here.
def random(request):
    context = {
        "randstr": get_random_string(length=14)
    }
    if not "attempts" in request.session:
        request.session["attempts"] = 0
    request.session["attempts"] += 1
    return render(request,"index.html", context=context)
def reset(request):
    request.session["attempts"] = 0
    return redirect('/random_word')