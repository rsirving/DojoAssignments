class Calculator implements java.io.Serializable {
    private double operandOne;
    private double operandTwo;
    private char operator;
    private double results;
    public Calculator(){

    }
    public void setOperandOne(double n){
        this.operandOne = n;
    }
    public void setOperandTwo(double n){
        this.operandTwo = n;
    }
    public void setOperator(char o){
        this.operator = o;
    }
    public double getOperandOne(){
        return this.operandOne;
    }
    public double getOperandTwo(){
        return this.operandTwo;
    }
    public char getOperator(){
        return this.operator;
    }

    public void performOperation(){
        if (this.operator == '-'){
            this.results = this.operandOne - this.operandTwo;
        } else if (this.operator == '+'){
            this.results = this.operandOne + this.operandTwo;
        }
    }

    public double getResults(){
        return this.results;
    }
}