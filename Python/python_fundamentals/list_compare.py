similar = True
if len(list_one) != len(list_two):
    similar = False
while similar == True:
    for i in range(0, len(list_one)):
        if list_one[i] == list_two[i]:
            continue
        else:
            similar = False
            break
    break
if similar == False:
    print "The lists are not the same."
if similar == True:
    print "The lists are the same."