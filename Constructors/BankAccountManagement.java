public class BankAccountManagement {

    // Inner BankAccount class
    static class BankAccount {
        public String accountNumber;    // Public - accessible everywhere
        protected String accountHolder; // Protected - accessible within package & subclass
        private double balance;         // Private - accessible only within this class

        // Constructor
        BankAccount(String accountNumber, String accountHolder, double balance) {
            this.accountNumber = accountNumber;
            this.accountHolder = accountHolder;
            this.balance = balance;
        }

        // Public method to get balance (accessing private variable)
        public double getBalance() {
            return balance;
        }

        // Public method to deposit money
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("₹" + amount + " deposited successfully.");
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Public method to withdraw money
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("₹" + amount + " withdrawn successfully.");
            } else {
                System.out.println("Insufficient balance or invalid amount.");
            }
        }
    }

    // Inner subclass SavingsAccount extending BankAccount
    static class SavingsAccount extends BankAccount {
        double interestRate; // Additional feature of SavingsAccount

        // Constructor
        SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
            super(accountNumber, accountHolder, balance);
            this.interestRate = interestRate;
        }

        // Method to display account details
        void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);   // public access
            System.out.println("Account Holder: " + accountHolder);   // protected access
            System.out.println("Balance: ₹" + getBalance());          // private accessed via public method
            System.out.println("Interest Rate: " + interestRate + "%");
            System.out.println("------------------------------");
        }
    }

    //  Main method to test
    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("9876543210", "Priya Sharma", 15000, 4.0);
        
        sa.displayAccountDetails();

        // Performing transactions
        sa.deposit(3000);
        sa.withdraw(5000);

        System.out.println("\nAfter Transactions:");
        sa.displayAccountDetails();
    }
}
