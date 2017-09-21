from django.forms import ModelForm
from .models import User

class userForm(ModelForm):
    class Meta:
        model = User
        fields = ['first_name', 'last_name', 'email']