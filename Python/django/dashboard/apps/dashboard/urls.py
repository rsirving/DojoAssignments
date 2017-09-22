from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^signin$',views.signin),
    url(r'^register$',views.register),
    url(r'^dashboard$',views.dash),
    url(r'^users/new$',views.newuser),
    url(r'^users/show/(?P<id>\d+)$',views.showuser),
    url(r'^users/edit/(?P<id>\d+)$',views.edituseradmin),
    url(r'^users/edit$',views.edituser),
    url(r'^$',views.),
]