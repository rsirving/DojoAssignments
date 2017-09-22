from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$',views.index),
    url(r'^signin$',views.signin),
    url(r'^register$',views.register),
    url(r'^dashboard$',views.dash),
    url(r'^users/new$',views.newuser),
    url(r'^users/show/(?P<id>\d+)$',views.showuser),
    url(r'^users/edit/(?P<id>\d+)$',views.editadmin),
    url(r'^users/edit$',views.edit),
    url(r'^users/delete/(?P<id>\d+)$',views.delete),
]