import java.util.Random;
import java.util.Arrays;

public class BankAccount {
    double checkingBalance;
    double savingsBalance;

    private static int numberOfAccounts = 0;
    private static double totalCash = 0.0;

    private static String randomAccount() {
        Random randomGenerator = new Random();
        int[] acctNum;
        acctNum = new int[10];
        for (int i = 0; i < 10; i++){
            int randomInt = randomGenerator.nextInt(10);
            acctNum[i] = randomInt;
        }
        return Arrays.toString(acctNum);
    }

    public static void main(String[] args){
        String accountNumber = randomAccount();
        numberOfAccounts++;
    }

    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    public void makeDeposit(String target, double cash){
        if (target == "checking"){
            this.checkingBalance += cash;
            totalCash += cash;
        } else if (target == "savings"){
            this.savingsBalance += cash;
            totalCash += cash;
        }
    }

    public void makeWithdrawal(String target, double cash){
        if (target == "checking"){
            if (cash <= this.checkingBalance){
                this.checkingBalance -= cash;
                totalCash -= cash;
            }
        } else if (target == "savings"){
            if (cash <= this.savingsBalance){
                this.savingsBalance -= cash;
                totalCash -= cash;
            }
        }
    }

    public double showBalance(){
        return this.checkingBalance + this.savingsBalance;
    }
}