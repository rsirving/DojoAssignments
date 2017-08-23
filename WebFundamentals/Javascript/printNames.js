var students = [ 
    {first_name:  'Michael', last_name : 'Jordan'},
    {first_name : 'John', last_name : 'Rosales'},
    {first_name : 'Mark', last_name : 'Guillen'},
    {first_name : 'KB', last_name : 'Tonel'}
]

var users = {
    'Students': [ 
        {first_name:  'Michael', last_name : 'Jordan'},
        {first_name : 'John', last_name : 'Rosales'},
        {first_name : 'Mark', last_name : 'Guillen'},
        {first_name : 'KB', last_name : 'Tonel'}
    ],
    'Instructors': [
        {first_name : 'Michael', last_name : 'Choi'},
        {first_name : 'Martin', last_name : 'Puryear'}
    ]
}

function printNames (roster) {
    for (var i = 0; i < roster.length; i++) {
        console.log((i+1) + " - " + roster[i].first_name + " " + roster[i].last_name);
    }
}

function printList (users) {
    console.log("Students");
    printNames(users.Students);
    console.log("Instructors");
    printNames(users.Instructors);
}