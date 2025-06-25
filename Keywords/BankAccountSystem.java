public class BankAccountSystem {

    // BankAccount class definition
    static class BankAccount {

        // Static variable shared by all BankAccount objects
        static String bankName = "State Bank of India";

        // Static variable to track total number of accounts
        private static int totalAccounts = 0;

        // Final variable: once assigned, cannot be changed
        private final int accountNumber;

        // Instance variable: unique to each account
        private String accountHolderName;

        // Constructor using 'this' to resolve variable ambiguity
        public BankAccount(int accountNumber, String accountHolderName) {
            this.accountNumber = accountNumber;               // 'this' distinguishes class variable from parameter
            this.accountHolderName = accountHolderName;
            totalAccounts++;                                  // Increment total account count whenever new object is created
        }

        // Static method to display total accounts created
        public static void getTotalAccounts() {
            System.out.println("Total Bank Accounts: " + totalAccounts);
        }

        // Method to display account details
        public void displayAccountDetails() {
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Bank Name: " + bankName);
            System.out.println("---------------------------");
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {
        // Creating BankAccount objects
        BankAccount acc1 = new BankAccount(1001, "Ravi Kumar");
        BankAccount acc2 = new BankAccount(1002, "Anjali Sharma");

        // instanceof check before accessing object details
        if (acc1 instanceof BankAccount) {
            acc1.displayAccountDetails();
        }

        if (acc2 instanceof BankAccount) {
            acc2.displayAccountDetails();
        }

        // Accessing static method without creating an object
        BankAccount.getTotalAccounts();
    }
}
