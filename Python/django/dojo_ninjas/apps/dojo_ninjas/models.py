from __future__ import unicode_literals

from django.db import models

# Create your models here.
class Dojos(models.Model):
    name = models.CharField(max_length=255, null=True)
    city = models.CharField(max_length=255, null=True)
    state = models.CharField(max_length=2, null=True)
    desc = models.TextField(null=True)

class Ninjas(models.Model):
    dojo_id = models.ForeignKey('Dojos', on_delete=models.PROTECT, null=True)
    first_name = models.CharField(max_length=255, null=True)
    last_name = models.CharField(max_length=255, null=True)