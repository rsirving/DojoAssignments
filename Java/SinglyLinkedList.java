public class SinglyLinkedList {
    Node head;
    public SinglyLinkedList(){
        this.head = null;
    }

    public void add(int value){
        Node node = new Node(value);
        if (this.head == null){
            this.head = node;
        } else {
            Node runner = this.head;
            while (runner.next != null){
                runner = runner.next;
            }
            runner.next = node;
        }
    }

    public void remove(){
        Node runner = this.head;
        while (runner.next.next != null){
            runner = runner.next;
        }
        runner.next = null;
    }

    public void printValues(){
        Node runner = this.head;
        while (runner != null){
            System.out.println(runner.value);
            runner = runner.next;
        }
    }
}