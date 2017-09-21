from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.index),
    url(r'^users$', views.index),
    url(r'^users/new$', views.new),
    url(r'^users/(?P<userid>\d+)/edit$', views.edit),
    url(r'^users/(?P<userid>\d+)$', views.show),
    url(r'^users/(?P<userid>\d+)/destroy$', views.destroy),
]