import java.util.*;

class WithdrawalRequest {
    String accountNumber;
    double amount;

    WithdrawalRequest(String accountNumber, double amount) {
        this.accountNumber = accountNumber;
        this.amount = amount;
    }
}

public class BankingSystem {
    private Map<String, Double> accounts = new HashMap<>();
    private Queue<WithdrawalRequest> requestQueue = new LinkedList<>();

    // Add account
    public void addAccount(String accountNumber, double balance) {
        accounts.put(accountNumber, balance);
    }

    // Queue withdrawal request
    public void requestWithdrawal(String accountNumber, double amount) {
        requestQueue.offer(new WithdrawalRequest(accountNumber, amount));
    }

    // Process withdrawals
    public void processWithdrawals() {
        System.out.println("\nProcessing Withdrawals:");
        while (!requestQueue.isEmpty()) {
            WithdrawalRequest req = requestQueue.poll();
            if (accounts.containsKey(req.accountNumber)) {
                double currentBalance = accounts.get(req.accountNumber);
                if (currentBalance >= req.amount) {
                    accounts.put(req.accountNumber, currentBalance - req.amount);
                    System.out.println("Withdrawal of ₹" + req.amount + " from " + req.accountNumber + " successful.");
                } else {
                    System.out.println("Insufficient funds in " + req.accountNumber);
                }
            } else {
                System.out.println("Account not found: " + req.accountNumber);
            }
        }
    }

    // Display sorted accounts by balance
    public void displayAccountsSortedByBalance() {
        System.out.println("\nAccounts Sorted by Balance:");
        TreeMap<Double, String> sorted = new TreeMap<>();
        for (Map.Entry<String, Double> entry : accounts.entrySet()) {
            sorted.put(entry.getValue(), entry.getKey());
        }
        for (Map.Entry<Double, String> entry : sorted.entrySet()) {
            System.out.println("Account: " + entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.addAccount("A101", 5000);
        bank.addAccount("A102", 3000);
        bank.addAccount("A103", 8000);

        bank.requestWithdrawal("A101", 2000);
        bank.requestWithdrawal("A102", 4000); // Insufficient
        bank.requestWithdrawal("A103", 1000);

        bank.processWithdrawals();
        bank.displayAccountsSortedByBalance();
    }
}
