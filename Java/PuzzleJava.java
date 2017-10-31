import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class PuzzleJava {
    Random rand = new Random();
    public static void main(String[] args) { }
    public ArrayList<Integer> puzzleOne() {
        int[] array1 = {3,5,1,2,7,9,8,13,25,32};
        int sum = 0;
        ArrayList<Integer> array2 = new ArrayList<Integer>();
        for (int number: array1){
            sum += number;
            if (number > 10) {
                array2.add(number);
            }
        }
        System.out.println(sum);
        return array2;
    }
    
    public ArrayList<String> puzzleTwo() {
        String[] array1 = {"Nancy", "Jinichi", "Fujibayashi", "Momochi", "Ishikawa"};
        ArrayList<String> array2 = new ArrayList<String>();
        for (String name : array1) {
            if ( name.length() > 5){
                array2.add(name);
            }
            System.out.println(name);
        }
        for (int i = 0; i < array1.length; i++){
            int shuffle = rand.nextInt(array1.length-1);
            String temp = array1[shuffle];
            array1[shuffle] = array1[i];
            array1[i] = temp;
        }
        return array2;
    }

    public void puzzleThree() {
        char[] array = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        for (int i = 0; i < array.length; i++){
            int shuffle = rand.nextInt(array.length-1);
            char temp = array[shuffle];
            array[shuffle] = array[i];
            array[i] = temp;           
        }
        System.out.println(array[25]);
        if ("aeiou".indexOf(array[25]) != -1){
            System.out.println("It's a vowel!");
        }
        System.out.println(array[0]);
        if ("aeiou".indexOf(array[0]) != -1){
            System.out.println("It's a vowel!");
        }
    }

    public int[] puzzleFour() {
        int[] array;
        array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = rand.nextInt(46)+55;
            System.out.println(array[i]);
        }
        return array;
    }

    public int[] puzzleFive() {
        int[] array;
        array = new int[10];
        for (int i = 0; i < 10; i++){
            array[i] = rand.nextInt(46)+55;
        }
        Arrays.sort(array);
        System.out.println(array.toString());
        System.out.println("Max: " + array[array.length-1]);
        System.out.println("Min: " + array[0]);
        return array;
    }

    public String puzzleSix() {
        char[] output;
        output = new char[5];
        String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lower = upper.toLowerCase();
        String digits = "0123456789";
        String alphanum = upper + lower + digits;
        char[] symbols = alphanum.toCharArray();
        for (int i = 0; i < 5; i++) {
            output[i] = symbols[rand.nextInt(symbols.length-1)];
        }
        String newOutput = String.valueOf(output);
        return newOutput;
    }

    public String[] puzzleSeven(){
        String[] list;
        list = new String[10];
        for (int i = 0; i < 10; i++) {
            list[i] = puzzleSix();
        }
        return list;
    }
}