from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def index(response):
    response = "Placeholder to later display a list of all the blogs."
    return HttpResponse(response)
def newform(response):
    response = "Placeholder to display a new form to create a new blog."
    return HttpResponse(response)
def create(response):
    return redirect('/blogs')
def show(response, num):
    response = "Placeholder to display blog " + num
    return HttpResponse(response)
def edit(response, num):
    response = "Placeholder to edit blog " + num
    return HttpResponse(response)
def destroy(response, num):
    return redirect('/blogs')