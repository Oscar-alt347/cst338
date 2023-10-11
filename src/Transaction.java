import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int accountNumber;
    private String transactionType;
    private double transactionAmount;
    private String transactionDateTime;

    public Transaction(int accountNumber, String transactionType, double transactionAmount) {
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.transactionAmount = transactionAmount;
        this.transactionDateTime = getCurrentDateTime();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public String getTransactionDateTime() {
        return transactionDateTime;
    }

    private String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
