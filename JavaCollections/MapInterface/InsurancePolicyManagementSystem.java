import java.time.LocalDate;
import java.util.*;

// Policy class to hold policy details
class Policy {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate, String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyholderName() {
        return policyholderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public String getCoverageType() {
        return coverageType;
    }

    public double getPremiumAmount() {
        return premiumAmount;
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate + ", " + coverageType + ", ₹" + premiumAmount + "]";
    }
}

public class InsurancePolicyManagementSystem {
    // Maps for storing policies
    private Map<String, Policy> hashMap = new HashMap<>();
    private Map<String, Policy> linkedHashMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> treeMap = new TreeMap<>();

    // Add a policy to all maps
    public void addPolicy(Policy policy) {
        // Add to HashMap and LinkedHashMap using policy number
        hashMap.put(policy.getPolicyNumber(), policy);
        linkedHashMap.put(policy.getPolicyNumber(), policy);

        // Add to TreeMap by expiry date
        treeMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieve a policy by its number
    public Policy getPolicyByNumber(String policyNumber) {
        return hashMap.get(policyNumber);
    }

    // List policies expiring in the next 30 days
    public void listExpiringPolicies() {
        System.out.println("\nPolicies expiring in next 30 days:");
        LocalDate now = LocalDate.now();
        LocalDate threshold = now.plusDays(30);

        treeMap.subMap(now, true, threshold, true)
               .values()
               .forEach(list -> list.forEach(System.out::println));
    }

    // List policies for a specific policyholder
    public void listPoliciesByHolder(String name) {
        System.out.println("\nPolicies for policyholder: " + name);
        for (Policy policy : hashMap.values()) {
            if (policy.getPolicyholderName().equalsIgnoreCase(name)) {
                System.out.println(policy);
            }
        }
    }

    // Remove expired policies
    public void removeExpiredPolicies() {
        System.out.println("\nRemoving expired policies...");
        LocalDate today = LocalDate.now();

        // Remove from treeMap and also from other maps
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = treeMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy p : entry.getValue()) {
                    hashMap.remove(p.getPolicyNumber());
                    linkedHashMap.remove(p.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }

    // Display all policies (in insertion order)
    public void displayAllPolicies() {
        System.out.println("\nAll policies in insertion order (LinkedHashMap):");
        linkedHashMap.values().forEach(System.out::println);
    }

    public static void main(String[] args) {
        InsurancePolicyManagementSystem system = new InsurancePolicyManagementSystem();

        // Sample Policies
        system.addPolicy(new Policy("P001", "Alice", LocalDate.now().plusDays(10), "Health", 3000));
        system.addPolicy(new Policy("P002", "Bob", LocalDate.now().plusDays(40), "Auto", 2500));
        system.addPolicy(new Policy("P003", "Alice", LocalDate.now().minusDays(5), "Home", 4000));
        system.addPolicy(new Policy("P004", "Charlie", LocalDate.now().plusDays(20), "Health", 3500));

        // Demonstrate features
        system.displayAllPolicies();

        System.out.println("\nGet policy by number (P002):");
        System.out.println(system.getPolicyByNumber("P002"));

        system.listExpiringPolicies();

        system.listPoliciesByHolder("Alice");

        system.removeExpiredPolicies();

        system.displayAllPolicies();
    }
}
