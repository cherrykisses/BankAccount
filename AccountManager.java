import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// Define the AccountManager class
class AccountManager {
    
    private ArrayList<BankAccount> accounts;

    public AccountManager() {
        accounts = new ArrayList<>();
    }

    // Helper method to create a new BankAccount object
    public static BankAccount newBankAccount(String accountNumber, String accountHolderName, String accountType, double balance) {
    return new BankAccount(accountNumber, accountHolderName, accountType, balance);
}

    // Method that adds a bank account
    public void addAccount(BankAccount account) {
            accounts.add(account);
        }

    // Method that loads a CSV file
    public void loadAccountsFromFile(String filepath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filepath))) {
            String line;
            StringBuilder content = new StringBuilder();
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
                String[] values = line.split(",");
                BankAccount account = newBankAccount(values[0], values[1], values[2], Double.parseDouble(values[3]));
                accounts.add(account);
            }
        } catch (IOException e) {
            System.out.println("Failed to load the CSV file: " + e.getMessage());
        }
    }

    // Method that finds a bank account by number
    public BankAccount findAccountByAccountNumber(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getaccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    // Method to deposit money into a bank account
    public void deposit(BankAccount account, double amount) {
        account.setbalance(account.getbalance() + amount);
    }

    // Method to withdraw money from a bank account
    public void withdraw(BankAccount account, double amount) {
        if (account.getbalance() - amount >= 0) {
            account.setbalance(account.getbalance() - amount);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}