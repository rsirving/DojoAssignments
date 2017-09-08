class Math_Dojo(object):
    def __init__(self):
        self.total = 0
        self.logged = True    
    
    def add(self, num, *extr):
        if type(num) == list:
            num = self.listsum(num)
        print type(extr)
        extrsum = 0
        for i in extr:
            i = self.listsum(i)
            extrsum += i
        num += extrsum
        self.total += num
        return self
    
    def subtract(self, num, *extr):
        if type(num) == list:
            num = self.listsum(num)
        extrsum = 0
        for i in extr:
            i = self.listsum(i)
            extrsum += i
        num += extrsum
        self.total -= num 
        return self
    
    def listsum(self, arr):
        temp = 0
        for i in arr:
            temp += i
        return temp

md = Math_Dojo()
print md.add(2).add([2,],5).subtract(3,2).total
print md.add([1], 3,4).add([3,5,7,8], [2,4.3,1.25]).subtract(2, [2,3], [1.1,2.3]).result