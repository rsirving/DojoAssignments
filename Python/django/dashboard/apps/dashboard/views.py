from django.shortcuts import render, request, redirect

# Create your views here.
def index(request):
    return render(request, 'index.html')

def signin(request):
    if request.method == "POST":
        form = request.POST
        if Users.objects.login(form):
            return redirect('/users/show/{{request.session.user.id}}')
        else:
            return redirect('/signin')
    else:
        return render(request, 'signin.html')

def register(request):
    if request.method == "POST":
        errors = Users.objects.basic_validator(request.POST)
        if len(errors) > 0:
            return redirect('/register')
        else:
            Users.objects.register(request.POST)
            return redirect('/users/show/{{request.session.user.id}}')
    else:
        return render(request, 'register.html')

def newuser(request):
    if request.session['user']['admin']:
        if request.method == "POST":
            errors = Users.objects.basic_validator(request.POST)
            if len(errors) > 0:
                return redirect('/newuser')
            else:
                Users.objects.newuser(request.POST)
        else:
            return render(request, 'newuser.html')
    else:
        return redirect('/')

def edit(request, id):
    context = {
        "user": request.session['user']
    }
    return render(request, 'edit.html')

def show(request, id):
    context = {
        "user": Users.objects.get(id=id),
        "messages": Messages.objects.filter(posted_to_user=id),
        "comments": Comments.objects.filter(message=Messages.objects.filter(posted_to_user=id))
    }
    return render('showuser.html', context)

def message(request):
    if request.method == "POST":
        form = request.POST
        message = Messages.objects.create(posted_to_user=form['posted_to_user'], user=request.session['user']['id'], message=form['message'])
        message.save()
    else:
        return redirect('/')

def comment(request):
    if request.method == "POST":
        form = request.POST
        comment = Comments.objects.create(user=request.session['user'], message=form['message'], comment=form['message'])

def delete(request, id):
    if request.method == "POST":
        if request.session['user']['admin']:
            d = User.objects.get
