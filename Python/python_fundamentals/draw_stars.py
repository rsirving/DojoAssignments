def draw_stars(arr):
    for i in range(len(arr)):
        for y in range(arr[i]):
            print "*",
        print "\n"

def draw_stars_alt(arr):
    for i in range(len(arr)):
        if type(arr[i]) is str:
            for y in range(len(arr[i])):
                print "{}".format(arr[i][0].lower()),
        else:
            for y in range(arr[i]):
                print "*",
        print "\n"