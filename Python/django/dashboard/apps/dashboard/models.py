from __future__ import unicode_literals

from django.db import models

# Create your models here.
class Users(models.Model):
    first_name = models.CharField(max_length=255)
    last_name = models.CharField(max_length=255)
    email = models.EmailField()
    password = models.CharField(max_length=255)
    admin = models.BooleanField(default=False)
    description = models.TextField(null=True)
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

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
    def register(self, postData):
        if len(Users.objects.all()) == 0:
            user = Users.objects.create(first_name=postData["first_name"], last_name=postData["last_name"], email=postData["email"], password=bcrypt.hashpw(str(postData["password"]), bcrypt.gensalt()), admin=True)
        else:
            user = Users.objects.create(first_name=postData["first_name"], last_name=postData["last_name"], email=postData["email"], password=bcrypt.hashpw(str(postData["password"]), bcrypt.gensalt()))
        request.session["user"] = user
        user.save()
    def newuser(self, postData):
        user = Users.objects.create(first_name=postData["first_name"], last_name=postData["last_name"], email=postData["email"], password=bcrypt.hashpw(str(postData["password"]), bcrypt.gensalt()))
        user.save()
    def login(self, postData):
        user = Users.objects.filter(email=postData["email"])
        if len(user) > 0:
            user = Users.objects.get(email=postData["email"])
            if bcrypt.checkpw(str(postData['password']).encode('utf-8'), str(user.password)):
                request.session['user'] = user
                return True
            else:
                return False
        else:
            return False
    def edit(self, postData):
        


class Messages(models.Model):
    posted_to_user = models.ForeignKey('Users', on_delete=models.CASCADE, related_name="message_on_wall")
    user = models.ForeignKey('Users', on_delete=models.CASCADE, related_name="posted_message")
    message = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)

class Comments(models.Model):
    user = models.ForeignKey('Users', on_delete=models.CASCADE, related_name="posted_comment")
    message = models.ForeignKey('Messages', on_delete=models.CASCADE, related_name="comment_on_message")
    comment = models.TextField()
    created_at = models.DateTimeField(auto_now_add=True)
    updated_at = models.DateTimeField(auto_now=True)