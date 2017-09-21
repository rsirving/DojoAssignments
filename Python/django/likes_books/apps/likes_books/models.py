from __future__ import unicode_literals

from django.db import models

# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=255, null=True)
    last_name = models.CharField(max_length=255, null=True)
    email = models.EmailField(null=True)
    created_at = models.DateField(auto_now_add=True)
    updated_at = models.DateField(auto_now=True)
    notes = models.TextField(null=True)

class Book(models.Model):
    uploader = models.ForeignKey('User', related_name="uploaded_books")
    liked_users = models.ManyToManyField('User', related_name="liked_books")
    name = models.CharField(max_length=255, null=True)
    desc = models.TextField(null=True)
    created_at = models.DateField(auto_now_add=True)
    updated_at = models.DateField(auto_now=True)