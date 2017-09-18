from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def register(request):
    response = "Placeholder for users to create a new user account."
    return HttpResponse(response)
def login(request):
    response = "Placeholder for users to log in."
    return HttpResponse(response)
def users(request):
    response = "Placeholder to later display the list of all users."
    return HttpResponse(response)