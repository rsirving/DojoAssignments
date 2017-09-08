def odd_even():
    value = ""
    for i in range(1,2001):
        if i % 2 != 0:
            value = "odd"
        else:
            value = "even"
        print "Number is {}. This is an {} number.".format(i,value)

def multiply(arr, num):
    for i in range(len(arr)):
        arr[i] *= num
    return arr

def layered_multiples(arr):
    new_array = []
    for i in range(len(arr)):
        subArray = []
        for y in range(0, arr[i]):
            subArray.append(1)
        new_array.append(subArray)
    return new_array