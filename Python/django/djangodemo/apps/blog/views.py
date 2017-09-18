from django.shortcuts import render, HttpResponse

# Create your views here.
def index(request):
    request = 'hello world'
    return HttpResponse("Hello World")