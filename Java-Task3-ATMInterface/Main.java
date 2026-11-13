
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Create Bank object
        Bank bank = new Bank();

        // Create ATM object
        ATM atm = new ATM(bank, sc);

        // Start ATM application
        atm.start();

        sc.close();
    }
}

