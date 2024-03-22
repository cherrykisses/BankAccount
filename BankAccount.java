
class BankAccount {
    // Properties of the BankAccount class
    private String accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;

    // Constructor to initialize a new Contact object
    public BankAccount(String accountNumber, String accountHolderName, String accountType, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.balance = balance;
    }

    // Implement the toString method to display account information
    @Override
    public String toString() {
        return "Account Number=" + accountNumber + '\'' +
                "Account Holder Name='" + accountHolderName + '\'' +
                ", Account Type='" + accountType + '\'' +
                ", Balance:='" + balance + '\'' +
                "";
    }

    // Getters and Setters (if necessary)
    public String getaccountNumber()
    {
        return accountNumber;
    }

    public void setaccountNumber(String newaccountNumber)
    {
        this.accountNumber = newaccountNumber;
    }

    public String getaccountHolderName()
    {
        return accountHolderName;
    }

    public void setName(String newaccountHolderName)
    {
        this.accountHolderName = newaccountHolderName;
    }

    public String getaccountType()
    {
        return accountType;
    }

    public void setaccountType(String newaccountType)
    {
        this.accountType = newaccountType;
    }

    public double getbalance()
    {
        return balance;
    }

    public void setbalance(double newbalance)
    {
        this.balance = newbalance;
    }

}