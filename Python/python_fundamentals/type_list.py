
l = [2,3,1,7,4,12]

isStr = False
isInt = False
sumString = ""
sum = 0
for count in range(0, len(l)):
    if isinstance(l[count], (int, float)):
        sum += l[count]
        isInt = True
    if isinstance(l[count], str):
        sumString = sumString + l[count] + " "
        isStr = True
if isInt and not isStr:
    print "The list you entered is of integer type."
    print "Sum:", sum
elif isStr and not isInt:
    print "The list you entered is of string type."
    print "String:", sumString
else:
    print "The list you entered is of mixed type."
    print "String:", sumString
    print "Sum:", sum