//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
//
//public class Bank {
//    private String bankName;
//    private ArrayList<Customer> customers;
//    private ArrayList<Account> accounts;
//   private ArrayList<Transaction> transactions;
//
//
//    public Bank(String bankName) {
//        this.bankName = bankName;
//        this.customers = new ArrayList<>();
//        this.transactions = new ArrayList<>();
//       this.accounts = new ArrayList<>();
//    }
//
//    public void readData(String fileName) {
//        Scanner inputStream = null;
//
//        try {
//            inputStream = new Scanner(new FileInputStream(fileName));
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found or could not be opened.");
//            System.exit(0);
//        }
//
//
//        int numCustomers = inputStream.nextInt();
//        inputStream.nextLine();
//
//
//
//        for (int i = 0; i < numCustomers; i++) {
//            String[] customerData = inputStream.nextLine().split(",");
//            String name = customerData[0];
//            String address = customerData[1];
//            String zipCode = customerData[2];
//            String ssn = customerData[3];
//
//
//
//            Customer customer = new Customer(name,address,ssn,zipCode);
//            customers.add(customer);
//
//        }
//
//
//        int numAccounts = inputStream.nextInt();
//
//        inputStream.nextLine();
//
//
//        for (int i = 0; i < numAccounts; i++) {
//
//            String[] accountData = inputStream.nextLine().split(",");
//            String ssn = accountData[0];
//            int accountNumber = Integer.parseInt(accountData[1]);
//            int accountType = Integer.parseInt(accountData[2]);
//            double balance = Double.parseDouble(accountData[3]);
//            Account account = new Account  (accountNumber, accountType,balance,ssn);
//            accounts.add(account);
//
//
//        }
//
//
//        inputStream.close();
//    }
//
//
//    private ArrayList<Customer> findCustomerBySSN(String ssn) {
//        ArrayList<Customer>matches= new ArrayList<>();
//
//        for (Customer customer : customers) {
//
//            if (customer.equals(ssn)) {
//                matches.add(customer);
//
//            }
//        }
//        return matches;
//    }
//
//    @Override
//    public  String toString() {
//        return "Bank Name: "  + bankName + "\n Number of customers:  "  +  customers + "\n NUmber of accounts: " + accounts;
//    }
//
//
//    public void bankInfo() {
//        System.out.printf("Bank name: %s \n", bankName);
//        System.out.printf("Number of Customers: %s", customers.size()  );
//        double totalBalance =0;
//        for (Customer customer : customers) {
//            System.out.printf("\n%s:%s",customer.getName(),customer.getSSn());
//            if (customer.getChecking()!= null){
//                String temp = String.format("\n%s:%s",customer.getName(),customer.getSSn());
//                totalBalance +=customer.getSaving().getBalance();
//            }
//            if (customer.getSaving()!= null){
//                String temp = String.format("%s:%s",customer.getName(),customer.getSSn());
//                totalBalance += customer.getSaving().getBalance();
//            }
//
//
//        }
//        System.out.printf("\nNumber of Account: %s",accounts.size());
//
//        for (Customer customer:customers){
//            if (customer.getChecking() != null) {
//                System.out.printf("%s:%s",customer.getSSn(),customer.getChecking().getBalance());
//                totalBalance += customer.getChecking().getBalance();
//            }
//            if (customer.getSaving() != null  ) {
//                System.out.printf("%s:%s",customer.getSSn(),customer.getSaving().getBalance());
//                totalBalance += customer.getSaving().getBalance();
//            }
//        }
//
//
//        System.out.printf("\nTotal balance: $%.2f", totalBalance);
//
//
//    }
//
//    public void accountInfo(int accountNumber) {
//        for (Customer customer : customers) {
//            if (customer.getChecking() != null && customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber)
//            {
//
//                System.out.println("Account Information:");
//                System.out.println("- Account Number: " + customer.getChecking().getAccountNumber());
//                System.out.println("- Account Type: Checking");
//                System.out.println("- Balance: $" + customer.getChecking().getBalance());
//                System.out.println("- Customer Name: " + customer.getName());
//                System.out.println("- Customer SSN: " + customer.getSSn());
//
//            }
//            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
//                System.out.println("Account Information:");
//                System.out.println("- Account Number: " + customer.getSaving().getAccountNumber());
//                System.out.println("- Account Type: Saving");
//                System.out.println("- Balance: $" + customer.getSaving().getBalance());
//                System.out.println("- Customer Name: " + customer.getName());
//
//
//            }
//        }
//
//
//
//        System.out.println("Account not found.");
//    }
//
//
//
//
//    public void deposit(int accountNumber, double amount) {
//        for (Customer customer : customers){
//            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
//                double newAmount = customer.getAmount() + amount;
//                customer.setAmount(newAmount);
//                System.out.println("Deposit successful.");
//                String temp = "Deposit" + amount  ;
//
//            }
//            if (customer.getSaving() != null &&customer.getSaving().getAccountNumber() == accountNumber) {
//                double newAmount = customer.getAmount() + amount;
//                customer.setAmount(newAmount);
//                String temp = "Deposit " + amount ;
//
//
//            }
//        }
//        System.out.println("Account not found.");
//    }
//
//
//    public void withdraw(int accountNumber, int amount) {
//
//        for (Customer customer : customers) {
//            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
//                if (customer.getAmount() >= amount)
//                {
//                    double newAmount = customer.getAmount() - amount;
//                    customer.setAmount(newAmount);
//                    System.out.println("Deposit successful.");
//                    String temp = "Withdraw " + amount ;
//
//                }
//            }
//            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
//                if (customer.getAmount() >= amount) {
//                    double newAmount = customer.getAmount() - amount;
//                    customer.setAmount(newAmount);
//                    System.out.println("Deposit successful");
//                    String temp = "Withdraw " + amount;
//
//                }
//            }
//        }
//        System.out.println("Account not found.");
//    }
//
//    public boolean closeAccount(int accountNumber) {
//        for (Customer customer : customers) {
//            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
//                String temp = "Account Closed" ;
//
//                accounts.remove(customer.getChecking());
//                customer.setChecking(null);
//                return true;
//            }
//
//            if (customer.getSaving() != null &&  customer.getSaving().getAccountNumber() == accountNumber) {
//                String temp = "Account Closed" ;
//
//                accounts.remove(customer.getSaving());
//                customer.setSaving(null);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public void transaction(int accountNumber) {
//        System.out.println("Transactions for Account Number: " + accountNumber);
//        for (Transaction transaction : transactions) {
//            if (transaction.getAccountNumber() == accountNumber) {
//                System.out.printf(
//                        "Type: %s, Amount: $%.2f, Date and Time: %s%n",
//                        transaction.getTransactionType(),
//                        transaction.getTransactionAmount(),
//                        transaction.getTransactionDateTime()
//                );
//            }
//        }
//    }
//
//
//
//}



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    private String bankName;
    private ArrayList<Customer> customers;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.transactions = new ArrayList<>();
        this.accounts = new ArrayList<>();
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

            Customer customer = new Customer(name, address, ssn, zipCode);
            customers.add(customer);
        }

        int numAccounts = inputStream.nextInt();
        inputStream.nextLine();

        for (int i = 0; i < numAccounts; i++) {
            String[] accountData = inputStream.nextLine().split(",");
            String ssn = accountData[0];
            int accountNumber = Integer.parseInt(accountData[1]);
            int accountType = Integer.parseInt(accountData[2]);
            double balance = Double.parseDouble(accountData[3]);
            Account account = new Account(accountNumber, accountType, balance, ssn);
            accounts.add(account);
        }

        inputStream.close();
    }

    private ArrayList<Customer> findCustomerBySSN(String ssn) {
        ArrayList<Customer> matches = new ArrayList<>();

        for (Customer customer : customers) {
            if (customer.equals(ssn)) {
                matches.add(customer);
            }
        }
        return matches;
    }

    @Override
    public String toString() {
        return "Bank Name: " + bankName + "\n Number of customers:  " + customers + "\n Number of accounts: " + accounts;
    }

    public void bankInfo() {
        System.out.printf("Bank name: %s \n", bankName);
        System.out.printf("Number of Customers: %s", customers.size());
        double totalBalance = 0;

        for (Customer customer : customers) {
            System.out.printf("\n%s:%s", customer.getName(), customer.getSSn());

            if (customer.getChecking() != null) {
                String temp = String.format("\n%s:%s", customer.getName(), customer.getSSn());
                totalBalance += customer.getChecking().getBalance();
            }
            if (customer.getSaving() != null) {
                String temp = String.format("%s:%s", customer.getName(), customer.getSSn());
                totalBalance += customer.getSaving().getBalance();
            }
        }

        System.out.printf("\nNumber of Accounts: %s", accounts.size());

        for (Customer customer : customers) {
            if (customer.getChecking() != null) {
                System.out.printf("%s:%s", customer.getSSn(), customer.getChecking().getBalance());
                totalBalance += customer.getChecking().getBalance();
            }
            if (customer.getSaving() != null) {
                System.out.printf("%s:%s", customer.getSSn(), customer.getSaving().getBalance());
                totalBalance += customer.getSaving().getBalance();
            }
        }

        System.out.printf("\nTotal balance: $%.2f", totalBalance);
    }

    public void accountInfo(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
                System.out.println("Account Information:");
                System.out.println("- Account Number: " + customer.getChecking().getAccountNumber());
                System.out.println("- Account Type: Checking");
                System.out.println("- Balance: $" + customer.getChecking().getBalance());
                System.out.println("- Customer Name: " + customer.getName());
                System.out.println("- Customer SSN: " + customer.getSSn());
            }

            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
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
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
                double newAmount = customer.getAmount() + amount;
                customer.setAmount(newAmount);
                System.out.println("Deposit successful.");
                String temp = "Deposit" + amount;
                // Do something with temp...
            }

            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
                double newAmount = customer.getAmount() + amount;
                customer.setAmount(newAmount);
                System.out.println("Deposit successful.");
                String temp = "Deposit " + amount;
                // Do something with temp...
            }
        }

        System.out.println("Account not found.");
    }

    public void withdraw(int accountNumber, int amount) {
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
                if (customer.getAmount() >= amount) {
                    double newAmount = customer.getAmount() - amount;
                    customer.setAmount(newAmount);
                    System.out.println("Deposit successful.");
                    String temp = "Withdraw " + amount;
                    // Do something with temp...
                }
            }

            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
                if (customer.getAmount() >= amount) {
                    double newAmount = customer.getAmount() - amount;
                    customer.setAmount(newAmount);
                    System.out.println("Deposit successful");
                    String temp = "Withdraw " + amount;
                    // Do something with temp...
                }
            }
        }

        System.out.println("Account not found.");
    }

    public boolean closeAccount(int accountNumber) {
        for (Customer customer : customers) {
            if (customer.getChecking() != null && customer.getChecking().getAccountNumber() == accountNumber) {
                accounts.remove(customer.getChecking());
                customer.setChecking(null);
                System.out.println("Account Closed");
                return true;
            }

            if (customer.getSaving() != null && customer.getSaving().getAccountNumber() == accountNumber) {
                accounts.remove(customer.getSaving());
                customer.setSaving(null);
                System.out.println("Account Closed");
                return true;
            }
        }

        return false;
    }

    public void transaction(int accountNumber) {
        System.out.println("Transactions for Account Number: " + accountNumber);
        for (Transaction transaction : transactions) {
            if (transaction.getAccountNumber() == accountNumber) {
                System.out.printf(
                        "Type: %s, Amount: $%.2f, Date and Time: %s%n",
                        transaction.getTransactionType(),
                        transaction.getTransactionAmount(),
                        transaction.getTransactionDateTime()
                );
            }
        }
    }
}
