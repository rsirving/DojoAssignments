class Animal(object):
    def __init__(self, name, health):
        self.name = name
        self.health = health
        self.logged = False   
    
    def walk(self):
        self.health -= 1
        return self

    def run(self):
        self.health -= 5
        return self

    def display_health(self):
        print self.health

quokka = Animal("Quokka", 20)
quokka.walk().walk().walk().run().run()
quokka.display_health()

class Dog(Animal):
    def __init__(self, name, health=120):
        self.name = name
        self.health = health
        self.logged = True
    
    def pet(self):
        self.health += 5
        return self

benji = Dog('benji')
benji.walk().walk().walk().run().run().pet().display_health()

class Dragon(Animal):
    def __init__(self, name, health=170):
        self.name = name
        self.health = health
        self.logged = True

    def fly(self):
        self.health -= 10
        return self

    def display_health(self):
        super(Dragon, self).display_health()
        print "I am a dragon."

glint = Dragon('glint')
glint.fly().display_health()
quokka.display_health()
quokka.pet()
quokka.fly()
benji.fly()