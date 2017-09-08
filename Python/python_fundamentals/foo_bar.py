def foobar():
    for i in range(100, 100001):
        prime = True
        square = False
        for y in range(2, i):
            if y * y == i:
                square = True
                prime = False
                break
            if i % y == 0:
                prime = False
        print i,
        if prime == True:
            print "Foo"
        elif square == True:
            print "Bar"
        else:
            print "FooBar"

foobar()