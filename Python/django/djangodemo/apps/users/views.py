from django.shortcuts import render, HttpResponse

# Create your views here.
def index(request):
    request="What's up users?"
    return HttpResponse(request)