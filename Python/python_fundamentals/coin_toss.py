import random

def coin_toss():
    heads = 0
    tails = 0
    result = ""
    for i in range(5000):
        coin = round(random.random())
        print coin
        if coin == 0:
            heads+=1
            result = "head"
        else:
            tails+=1
            result = "tail"
        print "Attempt #{}: Throwing a coin... It's a {}! Got {} head(s) and {} tail(s) so far.".format(i, result, heads, tails)

coin_toss()