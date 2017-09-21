from __future__ import unicode_literals

from django.db import models


class Author(models.Model):
    first_name = models.CharField(max_length=255, null=True)
    last_name = models.CharField(max_length=255, null=True)
    email = models.EmailField(null=True)
    created_at = models.DateField(auto_now=True)
    updated_at = models.DateField(auto_now=True)
    notes = models.TextField(null=True)

# Create your models here.
class Book(models.Model):
    author = models.ManyToManyField('Author')
    name = models.CharField(max_length=255, null=True)
    desc = models.TextField(null=True)
    created_at = models.DateField(auto_now=True)
    updated_at = models.DateField(auto_now=True)