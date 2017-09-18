from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def index(response):
    response = "Placeholder to display all the surveys created."
    return HttpResponse(response)
def new(response):
    response = "Placeholder for users to add a new survey."
    return HttpResponse(response)