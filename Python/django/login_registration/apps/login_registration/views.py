from django.shortcuts import render, redirect
from django.contrib import messages
from django.contrib.messages import get_messages
from .models import Users

# Create your views here.
def index(request):
    return render(request, 'index.html')

def register(request):
    if request.method == "POST":
        form = request.POST
        errors = Users.objects.basic_validator(form)
        if errors:
            for tag, error in errors.iteritems():
                messages.error(request, error, extra_tags=tag)
            return redirect('/')
        else:
            Users.objects.register_user(form)
            return redirect('/success')
    else:
        return redirect('/')

def login(request):
    if request.method == "POST":
        form = request.POST
        outcome = Users.objects.login(form)
        if outcome:
            return redirect('/success')
        else:
            return redirect('/')
    else:
        return redirect('/')

def success(request):
    return render(request, "success.html")