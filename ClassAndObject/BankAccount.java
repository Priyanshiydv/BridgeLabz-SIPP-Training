// Class to represent a Bank Account
class BankAccount {
    String accountHolder;   // Name of account holder
    String accountNumber;   // Account number
    double balance;         // Current balance in the account

    // Constructor to initialize account details
    BankAccount(String accountHolder, String accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to deposit money into the account
    void deposit(double amount) {
        balance += amount;
        System.out.println("₹" + amount + " deposited successfully.");
    }

    // Method to withdraw money from the account
    void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    // Method to display the current balance
    void displayBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Creating a BankAccount object
        BankAccount acc = new BankAccount("Amit", "1234567890", 10000);

        acc.displayBalance();    // Show balance
        acc.deposit(5000);       // Deposit ₹5000
        acc.withdraw(3000);      // Withdraw ₹3000
        acc.withdraw(15000);     // Try withdrawing ₹15000 (should fail)
        acc.displayBalance();    // Show balance again
    }
}
