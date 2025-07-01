// Superclass
class BankAccount {
    String accountNumber;
    double balance;

    BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    void displayBasicInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// Subclass 1
class SavingsAccount extends BankAccount {
    double interestRate;

    SavingsAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }

    void displayAccountType() {
        displayBasicInfo();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

// Subclass 2
class CheckingAccount extends BankAccount {
    double withdrawalLimit;

    CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }

    void displayAccountType() {
        displayBasicInfo();
        System.out.println("Account Type: Checking");
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

// Subclass 3
class FixedDepositAccount extends BankAccount {
    int maturityPeriod; // in months

    FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber, balance);
        this.maturityPeriod = maturityPeriod;
    }

    void displayAccountType() {
        displayBasicInfo();
        System.out.println("Account Type: Fixed Deposit");
        System.out.println("Maturity Period: " + maturityPeriod + " months");
    }
}

public class BankSystem {
    public static void main(String[] args) {
        SavingsAccount s = new SavingsAccount("SAV123", 25000, 4.5);
        CheckingAccount c = new CheckingAccount("CHK456", 50000, 10000);
        FixedDepositAccount f = new FixedDepositAccount("FD789", 100000, 24);

        s.displayAccountType();
        System.out.println("---------------------------");
        c.displayAccountType();
        System.out.println("---------------------------");
        f.displayAccountType();
    }
}
