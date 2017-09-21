from __future__ import unicode_literals

from django.db import models

# Create your models here.
class User(models.Model):
    first_name = models.CharField(max_length=255, null=True)
    last_name = models.CharField(max_length=255, null=True)
    email_address = models.CharField(max_length=255, null=True)
    age = models.IntegerField(null=True)
    created_at = models.DateField(auto_now = True)
    updated_at = models.DateField(auto_now = True)