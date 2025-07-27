import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

// Policy class with Comparable for TreeSet sorting by expiry date
class Policy implements Comparable<Policy> {
    private String policyNumber;
    private String policyholderName;
    private LocalDate expiryDate;
    private String coverageType;
    private double premiumAmount;

    public Policy(String policyNumber, String policyholderName, LocalDate expiryDate,
                  String coverageType, double premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyholderName = policyholderName;
        this.expiryDate = expiryDate;
        this.coverageType = coverageType;
        this.premiumAmount = premiumAmount;
    }

    // Getters
    public String getPolicyNumber() { return policyNumber; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getCoverageType() { return coverageType; }

    // hashCode and equals based on policyNumber
    @Override
    public int hashCode() {
        return Objects.hash(policyNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Policy)) return false;
        Policy other = (Policy) obj;
        return this.policyNumber.equals(other.policyNumber);
    }

    // TreeSet uses this to sort by expiry date
    @Override
    public int compareTo(Policy other) {
        return this.expiryDate.compareTo(other.expiryDate);
    }

    @Override
    public String toString() {
        return "[" + policyNumber + ", " + policyholderName + ", " + expiryDate +
                ", " + coverageType + ", ₹" + premiumAmount + "]";
    }
}

public class InsurancePolicySystem {
    Set<Policy> hashSet = new HashSet<>();
    Set<Policy> linkedHashSet = new LinkedHashSet<>();
    Set<Policy> treeSet = new TreeSet<>();

    // Store policy in all sets
    public void addPolicy(Policy policy) {
        hashSet.add(policy);
        linkedHashSet.add(policy);
        treeSet.add(policy);
    }

    // Display all unique policies
    public void displayAllPolicies(Set<Policy> policies) {
        for (Policy p : policies) {
            System.out.println(p);
        }
    }

    // Policies expiring within 30 days
    public void displayExpiringSoon(Set<Policy> policies) {
        LocalDate today = LocalDate.now();
        for (Policy p : policies) {
            long days = ChronoUnit.DAYS.between(today, p.getExpiryDate());
            if (days >= 0 && days <= 30) {
                System.out.println(p);
            }
        }
    }

    // Filter by coverage type
    public void displayByCoverageType(Set<Policy> policies, String type) {
        for (Policy p : policies) {
            if (p.getCoverageType().equalsIgnoreCase(type)) {
                System.out.println(p);
            }
        }
    }

    // Check duplicates by policy number
    public void displayDuplicatePolicies(List<Policy> policyList) {
        Set<String> seen = new HashSet<>();
        for (Policy p : policyList) {
            if (!seen.add(p.getPolicyNumber())) {
                System.out.println("Duplicate found: " + p);
            }
        }
    }

    // Compare performance of Sets
    public void comparePerformance(int count) {
        System.out.println("\nPerformance Comparison for " + count + " records:");

        List<Policy> testData = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            testData.add(new Policy("PN" + i, "Name" + i, LocalDate.now().plusDays(i),
                    "Auto", 1000 + i));
        }

        measureTime("HashSet", new HashSet<>(), testData);
        measureTime("LinkedHashSet", new LinkedHashSet<>(), testData);
        measureTime("TreeSet", new TreeSet<>(), testData);
    }

    private void measureTime(String type, Set<Policy> set, List<Policy> data) {
        long start = System.nanoTime();
        for (Policy p : data) {
            set.add(p);
        }
        for (Policy p : data) {
            set.contains(p);
        }
        for (Policy p : data) {
            set.remove(p);
        }
        long end = System.nanoTime();
        System.out.println(type + ": " + (end - start) / 1_000_000 + " ms");
    }

    // Main method to test
    public static void main(String[] args) {
        InsurancePolicySystem system = new InsurancePolicySystem();

        // Sample policies
        Policy p1 = new Policy("PN001", "Ally", LocalDate.now().plusDays(15), "Health", 5000);
        Policy p2 = new Policy("PN002", "Divya", LocalDate.now().plusDays(60), "Auto", 3500);
        Policy p3 = new Policy("PN003", "Charu", LocalDate.now().plusDays(10), "Home", 8000);
        Policy p4 = new Policy("PN004", "Dev", LocalDate.now().plusDays(5), "Auto", 4000);
        Policy p5 = new Policy("PN001", "Ally Duplicate", LocalDate.now().plusDays(15), "Health", 5000); // Duplicate

        // Add policies
        system.addPolicy(p1);
        system.addPolicy(p2);
        system.addPolicy(p3);
        system.addPolicy(p4);
        system.addPolicy(p5); // Won't be added (duplicate by policy number)

        System.out.println("\nAll Policies (HashSet):");
        system.displayAllPolicies(system.hashSet);

        System.out.println("\nPolicies Expiring Soon (within 30 days):");
        system.displayExpiringSoon(system.hashSet);

        System.out.println("\nPolicies with coverage type 'Auto':");
        system.displayByCoverageType(system.hashSet, "Auto");

        System.out.println("\nDuplicate Policy Check:");
        List<Policy> testList = Arrays.asList(p1, p2, p3, p4, p5);
        system.displayDuplicatePolicies(testList);

        system.comparePerformance(10000); // test with 10k records
    }
}
