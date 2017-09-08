class Patient(object):
    def __init__(self, id, name, allergies):
        self.id = id
        self.name = name
        self.allergies = allergies
        self.bednum = None
        self.logged = True

class Hospital(object):
    def __init__(self, name, capacity):
        self.name = name
        self.patients = []
        self.capacity = capacity
        self.logged = True

    def admit(self, patient):
        if len(self.patients) >= self.capacity:
            message = "Too full. Try again later."
        else:
            patient.bednum = len(self.patients)+1
            self.patients.append(patient)
            message = "Welcome to {} Hospital.".format(self.name)
        print message
    
    def discharge(self, patient):
        index = self.patients.index(patient)
        patient.bednum = None
        self.patients.pop(index)

JD = Patient(1, "JD", "None")
Turk = Patient(2, "Turk", "None")
SacredHeart = Hospital("Sacred Heart", 1)
SacredHeart.admit(JD)
SacredHeart.admit(Turk)