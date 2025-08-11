import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactions;

    // Constructor
    public Account(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account created with balance: " + initialBalance);
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | New Balance: " + balance);
            System.out.println("✅ Deposit successful!");
        } else {
            System.out.println("❌ Invalid deposit amount!");
        }
    }

    // Withdraw Method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | New Balance: " + balance);
            System.out.println("✅ Withdrawal successful!");
        } else if (amount > balance) {
            System.out.println("❌ Insufficient funds!");
        } else {
            System.out.println("❌ Invalid withdrawal amount!");
        }
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }

    // View Transaction History
    public void getTransactionHistory() {
        System.out.println("\n📜 Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Creating Account
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Account Holder Name: ");
        String holder = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        Account account = new Account(accNum, holder, balance);

        int choice;
        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transactions");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double dep = sc.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double wit = sc.nextDouble();
                    account.withdraw(wit);
                    break;
                case 3:
                    System.out.println("💰 Current Balance: " + account.getBalance());
                    break;
                case 4:
                    account.getTransactionHistory();
                    break;
                case 5:
                    System.out.println("👋 Thank you for banking with us!");
                    break;
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
