# Multiples
# Part I 
for count in range(1, 1000, 2):     # The third parameter specifies how much the count should increment by.
    print count

# Part II 
for count in range(5, 1000001, 5):  #The range isn't inclusive on the end value, so setting it between 5 and 1000001 ensures that it prints out 1000000.
    print count                     #It does, however, take ages to print.

# Sum List
a = [1, 2, 5, 10, 255, 3]
sum = 0                             #Setting the sum variable.
for count in range(0, len(a)):      #Range isn't inclusive at the end, so it won't index out of the list.
    sum+= a[count]                  #Iterates through the list, adding the value to the sum variable each time.
print sum                           #Prints the sum.

# Average List
a = [1, 2, 5, 10, 255, 3]
avg = 0                             #Setting the average variable.
for count in range(0, len(a)):      #Same as for the sum loop.
    avg+=a[count]                   #Same as for the sum loop.
avg /= len(a)                       #The only difference between getting the average and the sum. The two programs could be combined.
print avg