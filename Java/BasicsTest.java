public class BasicsTest{
    public static void main(String[] args){
        Basics basicJava = new Basics();
        // basicJava.print1To255();
        // basicJava.printOdds1to255();
        // basicJava.printSum();
        int[] array = {1,3,5,7,9,11};
        // basicJava.iterateArray(array);
        // basicJava.findMax(array);
        // basicJava.findAvg(array);
        // int [] y = basicJava.array1To255();
        // int number = 6;
        // int results = basicJava.greaterThan(array, number);
        // System.out.println(results);
        int[] array1 = basicJava.shiftArray(array);
        System.out.println(array1[5]);
    }
}