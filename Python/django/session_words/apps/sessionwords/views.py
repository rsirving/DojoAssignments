from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def index(request):
    if "words" not in request.session:
        request.session["words"] = []
    return render(request, "index.html")
def add(request):
    if request.method == "POST":
        word = {
            'word': str(request.POST['word']),
            'color': str(request.POST['color']),
            'size': str(request.POST['size'])
        }
        justwork = request.session["words"]
        justwork.append(word)
        request.session["words"] = justwork
        return redirect("/session_words")
    else:
        return redirect("/session_words")
def clear(request):
    del request.session["words"]
    return redirect("/session_words")