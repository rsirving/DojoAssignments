from django.shortcuts import render, redirect
from django import forms
from .models import User
from .forms import userForm

# Create your views here.

def index(request):
    context = {
        "users": User.objects.all()
    }
    return render(request, 'index.html', context)

def new(request):
    if request.method == "POST":
        form = userForm(request.POST)
        if form.is_valid():
            model_instance = form.save(commit=False)
            model_instance.save()
            return redirect('/')
    else:
        form = userForm()
        return render(request, 'new_user.html', {'form': form})

def edit(request, userid):
    if request.method=="POST":
        instance = User.objects.get(id=userid)
        form = userForm(request.POST or None, instance=instance)
        if form.is_valid():
            form.save()
            return redirect('/')
    else:
        context = {
            "first_name": User.objects.get(id=userid).first_name,
            "last_name": User.objects.get(id=userid).last_name,
            "email": User.objects.get(id=userid).email
        }
        form = userForm(initial=context)
        return render(request, 'edit.html', {'form':form})

def show(request, userid):
    context = {
        "user": User.objects.get(id=userid)
    }
    return render(request, 'single_user.html', context)

def destroy(request, userid):
    deleteUser = User.objects.get(id=userid)
    deleteUser.delete()
    return redirect('/users')