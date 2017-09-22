from __future__ import unicode_literals

from django.db import models
import bcrypt


# Create your models here.

class UserManager(models.Manager):
    def basic_validator(self, postData):
        errors = {}
        if len(postData['first_name']) < 2:
            errors['first_name'] = "First name must be longer than 2 characters."
        if len(postData['last_name']) < 2:
            errors['last_name'] = "Last name must be longer than 2 characters."
        if postData['password'] != postData['password-confirm']:
            errors['password_match'] = "Password and confirmation do not match."
        if len(postData['password']) < 8:
            errors['password_length'] = "Password must be more than 8 characters long."
        if len(Users.objects.filter(email=postData['email'])) > 0:
            errors['account'] = "Account already exists."
        return errors
    def register_user(self, postData):
        user = Users.objects.create(first_name=postData["first_name"], last_name=postData["last_name"], email=postData["email"], password=bcrypt.hashpw(str(postData["password"]), bcrypt.gensalt()))
        user.save()
    def login(self, postData):
        user = Users.objects.filter(email=postData["email"])
        if len(user) > 0:
            user = Users.objects.get(email=postData["email"])
            if bcrypt.checkpw(str(postData['password']).encode('utf-8'), str(user.password)):
                return True
            else:
                return False
        else:
            return False

class Users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField(max_length=255)
    password = models.CharField(max_length=255)
    created_at = models.DateTimeField(auto_now_add=True)
    objects = UserManager()