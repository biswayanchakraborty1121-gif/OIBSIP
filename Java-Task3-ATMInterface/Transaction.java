
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String transactionType;
    private double amount;
    private String dateTime;

    
    public Transaction(String transactionType, double amount) {

        this.transactionType = transactionType;
        this.amount = amount;

        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        this.dateTime = now.format(formatter);
    }

    
    public void displayTransaction() {

        System.out.println(
                transactionType + " | Amount: Rs. " + amount
                + " | Date: " + dateTime
        );
    }
}

