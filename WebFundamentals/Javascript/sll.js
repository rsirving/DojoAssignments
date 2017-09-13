function Node(val){
    this.val = val;
    this.next = null;
}

function SLL(){
    this.head = null;

    this.append = function(val){
        if (!this.head){
            this.head = new Node(val);
            return this.head;
        }
        var current = this.head;
        while(current.next){
            current = current.next;
        }
        current.next = new Node(val);
        return current.next;
    }
}

var list1 = new SLL();
list1.append(1);
list1.append(2);
list1.append(3);
list1.append(4);
list1.append(5);

console.log(list1.append(5));