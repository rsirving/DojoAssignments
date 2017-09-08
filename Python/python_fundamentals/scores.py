import random
random_num = random.randint(0,101)
print random_num

# Score: 60 - 69; Grade - D
# Score: 70 - 79; Grade - C
# Score: 80 - 89; Grade - B
# Score: 90 - 100; Grade - A
def scores():
    random_num = 0
    grade = ""
    for i in range(10):
        random_num = random.randint(59,100)
        if random_num >= 60 and random_num <= 69:
            grade = "D"
        elif random_num >= 70 and random_num <= 79:
            grade = "C"
        elif random_num >= 80 and random_num <= 89:
            grade = "B"
        else:
            grade = "A"
        print "Score: {}; Your grade is {}.".format(random_num, grade)
scores()