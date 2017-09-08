class MathDojo(object):
    def __init__(self):
        self.total = 0
        self.logged = True
    
    def add(self, num, *args):
        if type(num) == list:
            numsum = 0
            for i in num:
                numsum += i
            num = numsum
        for ar in args:
            if type(ar) == list:
                arsum = 0
                for i in ar:
                    arsum += i
                ar = arsum
            num += ar
        self.total += num
        return self

    def subtract(self, num, *args):
        if type(num) == list:
            numsum = 0
            for i in num:
                numsum += i
            num = numsum
        for ar in args:
            if type(ar) == list:
                arsum = 0
                for i in ar:
                    arsum += i
                ar = arsum
            num += ar
        self.total -= num
        return self

md = MathDojo()
print md.add(2).add(2,5,2,1,1).subtract(3,2,5).total
print md.add([1], 3,4).add([3,5,7,8], [2,4.3,1.25]).subtract(2, [2,3], [1.1,2.3]).total
# It works for part one and ALMOST works for part two.