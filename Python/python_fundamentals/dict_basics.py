info = {"name": "Stephen", "age": "23", "nation": "United States of America", "favlang": "Python"}
def print_info(data):
    print "My name is {}.".format(data["name"])
    print "My age is {}.".format(data["age"])
    print "My country of birth is {}.".format(data["nation"])
    print "My favorite language is {}.".format(data["favlang"])
print_info(info)