from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def index(request):
    if not "repeats" in request.session:
        request.session["repeats"] = 0
    return render(request, "index.html")
def submit(request):
    if request.method == "POST":
        request.session["repeats"] += 1
        print request.POST
        request.session["results"] = request.POST
        print request.session["results"]
        return redirect("/results")
    else:
        return redirect("/")
def results(request):
    return render(request, "results.html")