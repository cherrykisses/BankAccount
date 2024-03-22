import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountManager accountManager = new AccountManager();
        accountManager.loadAccountsFromFile("bank_accounts.csv");
        Main main = new Main(accountManager);
        main.run();
    }

    private AccountManager accountManager;
    private Scanner scanner;

    public Main(AccountManager accountManager) {
        this.accountManager = accountManager;
        this.scanner = new Scanner(System.in);
    }

    // Implementation of console menu
    public void run() {
        while (true) {
            System.out.println("Welcome to the bank. Please select an option to proceed.");
            System.out.println("1. View all bank accounts");
            System.out.println("2. Search for an account by account number");
            System.out.println("3. Deposit money into an account");
            System.out.println("4. Withdraw money from an account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                 for (BankAccount account : accountManager.getAccounts()) {
                      System.out.println(account);
                    }
                    break;
                case 2:
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
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}