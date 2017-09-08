class User(object):
    def __init__(self, name, email):
        self.name = name
        self.email = email
        self.logged = False

michael = User()
anna = User()
print michael, anna