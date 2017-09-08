# function input
my_dict = {
  "Speros": "(555) 555-5555",
  "Michael": "(999) 999-9999",
  "Jay": "(777) 777-7777"
}
#function output
[("Speros", "(555) 555-5555"), ("Michael", "(999) 999-9999"), ("Jay", "(777) 777-7777")]

def tuples_out(dict):
    output = []
    for i in range(len(dict)):
        output.append((dict.keys()[i], dict.values()[i]))
    return output
print tuples_out(my_dict)