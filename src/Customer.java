import java.util.ArrayList;

public class Customer {
    private String name;
    private String address;

    private String SSN;

    private String zipCode;

    private Account saving;
    private Account checking;

    private double amount;
    public Customer(String name,String address,String SSN,String zipCode){
        this.name = name;
        this.address = address;
        this.SSN = SSN;
        this.zipCode = zipCode;
        this.saving = getSaving();
        this.checking = getChecking();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSSn() {
        return SSN;
    }

    public void setSSn(String ssn) {
        this.SSN = ssn;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Account getSaving() {
        return saving;
    }

    public void setSaving(Account saving) {
        this.saving = saving;
    }

    public Account getChecking() {
        return checking;
    }

    public void setChecking(Account checking) {
        this.checking = checking;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;

    }



    public boolean equals (String ssn) {
        return this.SSN.substring(ssn.length() - 4).equals(SSN);
    }


}
