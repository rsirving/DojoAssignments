class Store(object):
    def __init__(self, products, location, owner):
        self.products = products
        self.location = location
        self.owner = owner
        self.logged = True
    
    def add_product(self, product):
        self.products.append(product)
        return self

    def remove_product(self, product):
        index = self.products.index(product)
        self.products.pop(index)
        return self

    def inventory(self):
        for i in self.products:
            i.display_info()