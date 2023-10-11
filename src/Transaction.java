import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
private  String accountNumber;
private String accountType;

private double amount;

private String timeStamp;


Transaction(String accountType,String account,double amount,String accountNumber){

    this.accountType = accountType;
    this.amount = amount;
    this.accountNumber = accountNumber;


    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
    this.timeStamp = now.format(formatter);
}


 public  String toSting() {
    if (accountType != null)
        return "Transaction{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountType='" + accountType + '\'' +
                ", amount=" + amount +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
     else return "Account Number: " +accountNumber + "Account is closed "+ "," + timeStamp;
}
}
