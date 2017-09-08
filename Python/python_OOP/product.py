class Product(object):
    def __init__(self, price, name, weight, brand, cost):
        self.price = price
        self.name = name
        self.weight = weight
        self.brand = brand
        self.cost = cost
        self.status = "for sale"
    
    def sell(self):
        self.status = "sold"
        return self
    
    def add_tax(self, tax):
        sales_tax = self.price * tax
        return "$", self.price + sales_tax
    
    def refund(self, reason):
        if reason == "defective":
            self.status = "defective"
            self.price = 0
        elif reason == "like new":
            self.status = "for sale"
        elif reason == "opened":
            self.status = "used"
            self.price *= .8
        return self

    def display_info(self):
        print "Price: ${} \nName: {} \nWeight: {} \nBrand: {} \nCost: {} \nStatus: {}".format(self.price, self.name, self.weight, self.brand, self.cost, self.status)
