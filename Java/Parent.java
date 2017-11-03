public class Parent {
    public Parent(){
        System.out.println("I'm a parent.");
    }

    public static void main(String[] args){ 
        Parent parent = new Parent();
        Child child = new Parent();
        // Grandchild grandchild = new Grandchild();
    }
}