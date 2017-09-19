from django.shortcuts import render, HttpResponse, redirect

# Create your views here.
def index(request):
    if not "totalprice" in request.session:
        request.session["totalprice"] = 0
    if not "totalproducts" in request.session:
        request.session["totalproducts"] = 0
    return render(request, "index.html")

def buy(request):
    if request.method == "POST":
        if int(request.POST["product_id"]) == 1:
            price = 19.99 * int(request.POST["quantity"])
            request.session["totalprice"] += price
            request.session["price"] = price
            request.session["totalproducts"] += int(request.POST["quantity"])
        if int(request.POST["product_id"]) == 2:
            price = 29.99 * int(request.POST["quantity"])
            request.session["totalprice"] += price
            request.session["price"] = price
            request.session["totalproducts"] += int(request.POST["quantity"])
        if int(request.POST["product_id"]) == 3:
            price = 4.99 * int(request.POST["quantity"])
            request.session["totalprice"] += price
            request.session["price"] = price
            request.session["totalproducts"] += int(request.POST["quantity"])
        if int(request.POST["product_id"]) == 4:
            price = 49.99 * int(request.POST["quantity"])
            request.session["totalprice"] += price
            request.session["price"] = price
            request.session["totalproducts"] += int(request.POST["quantity"])
        return redirect("/checkout", price=price)
    else:
        return redirect("/amadon")

def checkout(request):
    return render(request, "checkout.html")