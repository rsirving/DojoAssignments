public class CalculatorTest {
    public static void main(String[] args){
        Calculator c = new Calculator();
        c.setOperandOne(10.5);
        c.setOperator('+');
        c.setOperandTwo(5.2);
        c.performOperation();
        double result = c.getResults();
        System.out.println(result);
    }
}