public class SinglyLinkedListTest{
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.add(5);
        list.add(10);
        list.add(11);
        list.printValues();
        list.remove();
        list.printValues();
    }
}