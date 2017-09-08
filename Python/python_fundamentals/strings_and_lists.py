# .find()

# .replace()

# .min()

# .max()

# .sort()

# .len()

words = "It's thanksgiving day. It's my birthday,too!"
print words.find('day')
newWords = words.replace('day', 'month')

x = [2,54,-2,7,12,98]
print min(x)
print max(x)

y = ["hello",2,54,-2,7,12,98,"world"]
print y[0], y[-1]
ya = [y[0], y[-1]]

z = [19,2,54,-2,7,12,98,32,10,-3,6]
z = sorted(z)
zLen = len(z)/2
z2 = []
for count in range(0, zLen):
    z2.append(z.pop(0))
z.append(0)
for count in range(0, len(z)-1):
    z[-1-count] = z[-2-count]
z[0] = z2
print z