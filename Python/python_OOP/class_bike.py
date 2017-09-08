class Bike(object):
    def __init__(self, price, maxSpeed):
        self.price = price
        self.maxSpeed = maxSpeed
        self.miles = 0
        self.logged = False
    
    def display_info(self):
        print "Price: ${}, Max Speed: {} MPH, Miles = {} miles".format(self.price, self.maxSpeed, self.miles)
    
    def riding(self):
        print "Riding..."
        self.miles += 10
        return self
    
    def reverse(self):
        print "Reversing..."
        self.miles -= 5
        if self.miles <= 0:
            self.miles = 0
        return self

first = Bike(200, 40)
second = Bike(100, 20)
third = Bike(50, 10)

first.riding().riding().riding().reverse()
first.display_info()

second.riding().riding().reverse().reverse()
second.display_info()

third.reverse().reverse().reverse()
third.display_info()