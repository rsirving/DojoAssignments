class Car(object):
    def __init__(self, price, speed, fuel, mileage):
        self.price = price
        if self.price >= 10000:
            self.tax = .15
        else:
            self.tax = .12
        self.speed = speed
        self.fuel = fuel
        self.mileage = mileage
        self.display_all()
    
    def display_all(self):
        print "Price: ${} \nSpeed: {} MPH \nFuel: {} \nMileage: {} mpg \nTax: {}".format(self.price, self.speed, self.fuel, self.mileage, self.tax)

first = Car(10000, 50, "Full", 25)
second = Car(10001, 60, "Bone dry", 40)
third = Car(9999, 10, "Probably too full", 10)
fourth = Car(15, 1, "Can't find the damn thing", 10000000)
fifth = Car(1200000, 100, "The yellow light hasn't come on yet, we're fine", .5)
sixth = Car(0, 0, "Nonexistant", 0)