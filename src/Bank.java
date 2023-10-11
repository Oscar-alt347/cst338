import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Bank {
    private String bankName;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    public String timeStamp;
private ArrayList<String> Lastfourdigits ;
private ArrayList<String> TrascationInfo;
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.Lastfourdigits = new ArrayList<>();
        this.TrascationInfo = new ArrayList<>();
    }

    public void readData(String fileName) {
        Scanner inputStream = null;

        try {
            inputStream = new Scanner(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found or could not be opened.");
            System.exit(0);
        }


        int numCustomers = inputStream.nextInt();
        inputStream.nextLine();



        for (int i = 0; i < numCustomers; i++) {
            String[] customerData = inputStream.nextLine().split(",");
            String name = customerData[0];
            String address = customerData[1];
            String zipCode = customerData[2];
            String ssn = customerData[3];



            Customer customer = new Customer(name,address,ssn,zipCode);
            customers.add(customer);
            String lastFour = ssn.substring(ssn.length()-4);
            Lastfourdigits.add(lastFour);
        }


        int numAccounts = inputStream.nextInt();

        inputStream.nextLine();


        for (int i = 0; i < numAccounts; i++) {

            String[] accountData = inputStream.nextLine().split(",");
            String ssn = accountData[0];
            int accountNumber = Integer.parseInt(accountData[1]);
            boolean accountType = Boolean.parseBoolean(accountData[2]);
            double balance = Double.parseDouble(accountData[3]);
            Account account = new Account  (String.valueOf(accountNumber), accountType,balance);
            accounts.add(account);


        }


        inputStream.close();
    }


    private ArrayList<Customer> findCustomerBySSN(String ssn) {
        ArrayList<Customer>matches= new ArrayList<>();

        for (Customer customer : customers) {

            if (customer.equals(ssn)) {
                matches.add(customer);

            }
        }
        return matches;
    }

@Override
    public  String toString() {
return "Bank Name: "  + bankName + "\n Number of customers:  "  +  customers + "\n NUmber of accounts: " + accounts;
    }


    public void bankInfo() {
        System.out.printf("Bank name: %s \n", bankName);
        System.out.printf("Number of Customers: %s", customers.size()  );
             for (Customer customer : customers) {
                System.out.printf("\n%s:%s",customer.getName(),customer.getSSn());
                 if (customer.getChecking()!= null){
                     String temp = String.format("\n%s:%s",customer.getName(),customer.getSSn());
                     totalBalance +=customer.getSaving().getBalance();
                 }
                 if (customer.getSaving()!= null){
                     String temp = String.format("%s:%s",customer.getName(),customer.getSSn());
                     totalBalance += customer.getSaving().getBalance();
                 }


             }
        System.out.printf("\nNumber of Account: %s",accounts.size());

             for (Customer customer:customers){
                 if (customer.getChecking() != null) {
                     System.out.printf("%s:%s",customer.getSSn(),customer.getChecking().getBalance());
                     totalBalance += customer.getChecking().getBalance();
                 }
                 if (customer.getSaving() != null  ) {
                     System.out.printf("%s:%s",customer.getSSn(),customer.getSaving().getBalance());
                     totalBalance += customer.getSaving().getBalance();
                 }
             }


        System.out.printf("\nTotal balance: $%.2f", totalBalance);


    }

    public void accountInfo(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() .equals( Integer.toString(accountNumber)))
            {

                System.out.println("Account Information:");
                System.out.println("- Account Number: " + customer.getChecking().getAccountNumber());
                System.out.println("- Account Type: Checking");
                System.out.println("- Balance: $" + customer.getChecking().getBalance());
                System.out.println("- Customer Name: " + customer.getName());
                System.out.println("- Customer SSN: " + customer.getSSn());

            }
            if (customer.getSaving() != null && customer.getSaving().getAccountNumber().equals(Integer.toString(accountNumber))) {
                System.out.println("Account Information:");
                System.out.println("- Account Number: " + customer.getSaving().getAccountNumber());
                System.out.println("- Account Type: Saving");
                System.out.println("- Balance: $" + customer.getSaving().getBalance());
                System.out.println("- Customer Name: " + customer.getName());


            }
        }



        System.out.println("Account not found.");
    }




    public void deposit(int accountNumber, double amount) {
        for (Customer customer : customers){
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber().equals(Integer.toString(accountNumber))) {
                double newAmount = customer.getAmount() + amount;
                customer.setAmount(newAmount);
                System.out.println("Deposit successful.");
                String temp = "Deposit" + amount + timeStamp  ;
                TrascationInfo.add(temp);
            }
            if (customer.getSaving() != null && customer.getSaving().getAccountNumber().equals(Integer.toString(accountNumber))) {
                double newAmount = customer.getAmount() + amount;
                customer.setAmount(newAmount);
                String temp = "Deposit " + amount + timeStamp;
                TrascationInfo.add(temp);

            }
        }
        System.out.println("Account not found.");
    }


    public void withdraw(int accountNumber, int amount) {

        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber().equals(Integer.toString(accountNumber))) {
               if (customer.getAmount() >= amount)
               {
                double newAmount = customer.getAmount() - amount;
                customer.setAmount(newAmount);
                System.out.println("Deposit successful.");
                   String temp = "Withdraw " + amount + timeStamp;
                   TrascationInfo.add(temp);
               }
            }
            if (customer.getSaving() != null && customer.getSaving().getAccountNumber().equals(Integer.toString(accountNumber))) {
                if (customer.getAmount() >= amount) {
                    double newAmount = customer.getAmount() - amount;
                    customer.setAmount(newAmount);
                    System.out.println("Deposit successful");
                    String temp = "Withdraw " + amount;
                    TrascationInfo.add(temp);
                }
            }
        }
        System.out.println("Account not found.");
    }

    public boolean closeAccount(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber().equals(Integer.toString(accountNumber))) {
                String temp = "Account Closed" + timeStamp;
                TrascationInfo.add(temp);
                accounts.remove(customer.getChecking());
                customer.setChecking(null);
                return true;
            }

            if (customer.getSaving() != null && customer.getSaving().getAccountNumber().equals(Integer.toString(accountNumber))) {
                String temp = "Account Closed" + timeStamp;
                TrascationInfo.add(temp);
                accounts.remove(customer.getSaving());
                customer.setSaving(null);
                return true;
            }
        }
        return false;
    }

    public void transaction(int accountNumber) {
        System.out.println("Account Number: " + accountNumber);
        for (int i = 0; i < TrascationInfo.size(); i++) {

            System.out.printf(TrascationInfo.get(i));
        }
        for (Customer customer : customers){
            System.out.printf("Account holder: %s ,  %s",customer.getSSn(),customer.getAmount());
            continue;}
    }

    public String TimeStamp (){

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss");
        this.timeStamp = now.format(formatter);
       return timeStamp;
    }

}