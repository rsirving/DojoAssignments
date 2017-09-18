from django.conf.urls import url
from . import views

urlpatterns = [
    url(r'^$', views.random),
    url(r'^random_word', views.random),
    url(r'^reset$', views.reset),
]