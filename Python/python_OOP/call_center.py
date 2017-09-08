class Call(object):
    def __init__(self, id, name, number, time, reason):
        self.id = id
        self.name = name
        self.number = number
        self.time = time
        self.reason = reason
        self.logged = True

    def display(self):
        print "ID: {} \nName: {} \nNumber {} \nTime: {} \nReason: {}".format(self.id, self.name, self.number, self.time, self.reason)

first = Call(12, "John Doe", "999-555-1212", "12:05 am", "Was lonely")
second = Call(13, "Jane Doe", "888-555-3434", "12:10 am", "Wrong number")
class CallCenter(object):
    def __init__(self, calls):
        self.calls = calls
        self.queue = len(calls)
        self.logged = True

    def add(self, call):
        self.calls.append(call)
        self.queue += 1
        return self

    def remove(self):
        self.calls.pop(0)
        self.queue-=1
        return self

    def info(self):
        print "Length of queue: {}".format(self.queue)
        for i in self.calls:
            print "Name: {}, Number: {}".format(i.name, i.number)

center = CallCenter([first, second])
center.info()
third = Call(14, "Joe Doe", "777-555-5656", "12:15 am", "Butt dial")
center.add(third)
center.info()
center.remove()
center.info()