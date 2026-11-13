
import java.util.ArrayList;
import java.util.Scanner;

public class ATM {

    private Bank bank;
    private Scanner sc;
    private Account currentAccount;

    private ArrayList<Transaction> transactions;

    
    public ATM(Bank bank, Scanner sc) {

        this.bank = bank;
        this.sc = sc;
        this.transactions = new ArrayList<>();
    }

    
    public void start() {

        int attempts = 0;
        boolean loggedIn = false;

        System.out.println("================================");
        System.out.println("          WELCOME TO ATM");
        System.out.println("================================");

        while (attempts < 3) {

            System.out.print("Enter User ID: ");
            String userId = sc.next();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            currentAccount = bank.authenticate(userId, pin);

            if (currentAccount != null) {

                loggedIn = true;
                System.out.println("\nLogin Successful!");
                System.out.println("Welcome, "
                        + currentAccount.getAccountHolder());

                break;

            } else {

                attempts++;

                System.out.println("Invalid User ID or PIN!");
                System.out.println("Attempts remaining: "
                        + (3 - attempts));
            }
        }

        if (!loggedIn) {

            System.out.println("\nAccount access blocked!");
            System.out.println("Too many incorrect login attempts.");

            return;
        }

        showMenu();
    }

    
    private void showMenu() {

        int choice;

        do {

            System.out.println("\n================================");
            System.out.println("             ATM MENU");
            System.out.println("================================");

            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Deposit Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Check Balance");
            System.out.println("6. Quit");

            System.out.print("\nEnter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    showTransactionHistory();
                    break;

                case 2:
                    withdrawMoney();
                    break;

                case 3:
                    depositMoney();
                    break;

                case 4:
                    transferMoney();
                    break;

                case 5:
                    checkBalance();
                    break;

                case 6:
                    System.out.println("\nThank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);
    }

    
    private void showTransactionHistory() {

        System.out.println("\n======= TRANSACTION HISTORY =======");

        if (transactions.isEmpty()) {

            System.out.println("No transactions available.");

        } else {

            for (Transaction transaction : transactions) {
                transaction.displayTransaction();
            }
        }

        System.out.println("===================================");
    }

    
    private void withdrawMoney() {

        System.out.print("Enter withdrawal amount: Rs. ");
        double amount = sc.nextDouble();

        if (currentAccount.withdraw(amount)) {

            transactions.add(
                    new Transaction("Withdrawal", amount)
            );
        }
    }

    
    private void depositMoney() {

        System.out.print("Enter deposit amount: Rs. ");
        double amount = sc.nextDouble();

        if (amount > 0) {

            currentAccount.deposit(amount);

            transactions.add(
                    new Transaction("Deposit", amount)
            );

        } else {

            System.out.println("Invalid deposit amount!");
        }
    }

    
    private void transferMoney() {

        System.out.print("Enter receiver User ID: ");
        String receiverId = sc.next();

        Account receiver = bank.findAccount(receiverId);

        if (receiver == null) {

            System.out.println("Receiver account not found!");
            return;
        }

        if (receiver == currentAccount) {

            System.out.println("You cannot transfer money to yourself!");
            return;
        }

        System.out.print("Enter transfer amount: Rs. ");
        double amount = sc.nextDouble();

        if (currentAccount.transfer(amount)) {

            receiver.deposit(amount);

            transactions.add(
                    new Transaction("Transfer to " + receiverId, amount)
            );

            System.out.println("Transfer successful!");
        }
    }

    
    private void checkBalance() {

        System.out.println("\nAvailable Balance: Rs. "
                + currentAccount.getBalance());
    }
}
