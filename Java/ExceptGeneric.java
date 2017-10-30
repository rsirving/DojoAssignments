import java.util.ArrayList;
import java.util.*;
public class ExceptGeneric {
    public static void main(String[] args){
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");
        for (Object item : myList){
            Integer castedValue = (Integer) item;
            System.out.println(castedValue);
        }
    }
}