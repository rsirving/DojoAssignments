students = [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
]
def names_part_one(arr):
    for i in range(len(arr)):
        print "{} {}".format(arr[i]["first_name"], arr[i]["last_name"])

users = {
 'Students': [
     {'first_name':  'Michael', 'last_name' : 'Jordan'},
     {'first_name' : 'John', 'last_name' : 'Rosales'},
     {'first_name' : 'Mark', 'last_name' : 'Guillen'},
     {'first_name' : 'KB', 'last_name' : 'Tonel'}
  ],
 'Instructors': [
     {'first_name' : 'Michael', 'last_name' : 'Choi'},
     {'first_name' : 'Martin', 'last_name' : 'Puryear'}
  ]
 }

def names_additive(arr):
    for i in range(len(arr)):
        namelen = len(arr[i]['first_name']) + len(arr[i]['last_name'])
        print "# {} - {} {} - {}".format(i+1, arr[i]["first_name"], arr[i]["last_name"], namelen)

def names_part_two(arr):
    print "Students"
    names_additive(arr["Students"])
    print "Instructors"
    names_additive(arr['Instructors'])

names_part_two(users)