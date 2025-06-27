import java.util.*;

class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public void viewBalance() {
        System.out.println("Account Number: " + accountNumber + ", Balance: ₹" + balance);
    }
}

class Customer {
    private String name;
    private List<Account> accounts;

    public Customer(String name) {
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void viewAllAccounts() {
        System.out.println("Customer: " + name);
        for (Account acc : accounts) {
            acc.viewBalance();
        }
    }
}

class Bank {
    private String bankName;
    private List<Customer> customers;

    public Bank(String name) {
        this.bankName = name;
        this.customers = new ArrayList<>();
    }

    public void openAccount(Customer customer, String accNumber, double initialDeposit) {
        Account newAccount = new Account(accNumber, initialDeposit);
        customer.addAccount(newAccount);
        if (!customers.contains(customer)) {
            customers.add(customer); // Associate customer with the bank
        }
        System.out.println("Account opened for " + customer + " in " + bankName);
    }

    public void showCustomers() {
        System.out.println("Customers of " + bankName + " Bank:");
        for (Customer c : customers) {
            c.viewAllAccounts();
        }
    }
}

// Main class to demonstrate association
public class BankSystem {
    public static void main(String[] args) {
        Bank sbi = new Bank("SBI");

        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts for customers through the bank
        sbi.openAccount(alice, "SBI123", 5000);
        sbi.openAccount(bob, "SBI456", 10000);
        sbi.openAccount(alice, "SBI789", 7000); // Alice with second account

        // View customers and balances
        sbi.showCustomers();
    }
}
