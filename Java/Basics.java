public class Basics {
    public void print1To255(){
        for (int i = 1; i <= 255; i++){
            System.out.println(i);
        }
    }

    public void printOdds1To255(){
        for (int i = 1; i <= 255; i += 2){
            System.out.println(i);
        }
    }

    public void printSum(){
        int sum = 0;
        for (int i = 0; i <= 255; i++){
            sum += i;
            System.out.println("New number: " + i + " Sum: " + sum);
        }
    }

    public void iterateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void findMax(int[] array) {
        int max = array[0];
        for (int number : array){
            if (number > max){
                max = number;
            }
        }
        System.out.println(max);
    }

    public void findAvg(int[] array) {
        int avg = 0;
        for (int number : array) {
            avg += number;
        }
        avg = avg / array.length;
        System.out.println(avg);
    }

    public int[] array1To255() {
        int[] y;
        y = new int[128];
        int place = 0;
        for (int i = 1; i <= 255; i += 2) {
            y[place] = i;
            System.out.println(y[place]);
            place++;
        }
        return y;
    }

    public int greaterThan(int[] array, int y){
        int result = 0;
        for (int number : array) {
            if (number > y) {
                result++;
            }
        }
        return result;
    }

    public int[] squareArray(int[] array) {
        for (int number : array) {
            number *= number;
        }
        return array;
    }

    public int[] removeNegatives(int[] array) {
        for (int number : array) {
            if (number < 0){
                number = 0;
            }
        }
        return array;
    }

    public int[] maxMinAvg(int[] array) {
        int max = array[0];
        int min = array[0];
        int avg = 0;
        for (int number: array) {
            if (number > max){
                max = number;
            }
            if (number < min) {
                min = number;
            }
            avg += number;
        }
        avg = avg / array.length;
        int[] results = { max, min, avg };
        return results;
    }

    public int[] shiftArray(int[] array) {
        for (int i = 0; i < array.length; i++){
            if ( i == array.length - 1 ){
                array[i] = 0;
            } else {
                array[i] = array[i+1];
            }
        }
        return array;
    }

}