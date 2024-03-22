import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Create an instance of AccountManager and load accounts from a CSV file
        AccountManager accountManager = new AccountManager();
        accountManager.loadAccountsFromFile("bank_accounts.csv");

        // Create a new Main instance with the loaded AccountManager
        Main main = new Main(accountManager);

        // Run the console menu
        main.run();
    }

    // Instance variables for AccountManager and Scanner
    private AccountManager accountManager;
    private Scanner scanner;

    // Main constructor to initialize the AccountManager and Scanner
    public Main(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.scanner = new Scanner(System.in);
    }

    // Implementation of console menu using a switch statement
    // While the application runs, the main menu is displayed
    public void run() {
        while (true) {
            System.out.println("Welcome to the bank. Please select an option to proceed.");
            System.out.println("1. View all bank accounts");
            System.out.println("2. Search for an account by account number");
            System.out.println("3. Deposit money into an account");
            System.out.println("4. Withdraw money from an account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            // Get user input and process the user's choice
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                     // Display all bank accounts
                    for (BankAccount account : accountManager.getAccounts()) {
                        System.out.println(account);
                    }
                    break;
                case 2:
                    // Search for an account by account number
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.nextLine();
                    BankAccount account = accountManager.findAccountByAccountNumber(accountNumber);
                    if (account != null) {
                        System.out.println(account);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 3:
                    // Deposit money into an account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = accountManager.findAccountByAccountNumber(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to deposit: ");
                        double amount = scanner.nextDouble();
                        accountManager.deposit(account, amount);
                        System.out.println("Deposit successful");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    // Withdraw money from an account
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    account = accountManager.findAccountByAccountNumber(accountNumber);
                    if (account != null) {
                        System.out.print("Enter amount to withdraw: ");
                        double amount = scanner.nextDouble();
                        accountManager.withdraw(account, amount);
                        System.out.println("Withdrawal successful");
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 5:
                    // Exit the application
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    // Invalid character
                    System.out.println("Invalid choice");
            }
        }
    }
}