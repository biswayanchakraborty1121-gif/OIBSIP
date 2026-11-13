
import java.util.ArrayList;

public class Bank {

    private ArrayList<Account> accounts;

    public Bank() {

        accounts = new ArrayList<>();

        accounts.add(new Account("Biswayan", "user101", 1234, 10000));
        accounts.add(new Account("Rahul", "user102", 5678, 15000));
        accounts.add(new Account("Amit", "user103", 9999, 20000));
    }

    public Account authenticate(String userId, int pin) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)
                    && account.checkPin(pin)) {

                return account;
            }
        }

        return null;
    }

    public Account findAccount(String userId) {

        for (Account account : accounts) {

            if (account.getUserId().equals(userId)) {
                return account;
            }
        }

        return null;
    }
}
