public class Account {
    private int accountNumber;
    private int accountType;
    private double balance;
    private String ssn;

    public Account(int accountNumber, int accountType, double balance, String ssn) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.ssn = ssn;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public String getSsn() {
        return ssn;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
