
public class Account {


    private String accountHolder;
    private String userId;
    private int pin;
    private double balance;

    
    public Account(String accountHolder, String userId, int pin, double balance) {

        this.accountHolder = accountHolder;
        this.userId = userId;
        this.pin = pin;
        this.balance = balance;
    }

    
    public String getAccountHolder() {
        return accountHolder;
    }

    
    public String getUserId() {
        return userId;
    }

    
    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    
    public double getBalance() {
        return balance;
    }

    
    public void deposit(double amount) {

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    
    public boolean withdraw(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful!");
            return true;
        }

        System.out.println("Insufficient Funds or Invalid Amount!");
        return false;
    }

    
    public boolean transfer(double amount) {

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }

        System.out.println("Insufficient Funds or Invalid Amount!");
        return false;
    }
}
