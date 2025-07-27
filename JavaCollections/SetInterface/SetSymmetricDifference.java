import java.util.*;

public class SetSymmetricDifference {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        // Clone sets
        Set<Integer> diff1 = new HashSet<>(set1);
        Set<Integer> diff2 = new HashSet<>(set2);

        // Remove common elements
        diff1.removeAll(set2); // Elements only in set1
        diff2.removeAll(set1); // Elements only in set2

        // Combine the remaining elements
        diff1.addAll(diff2);

        System.out.println("Symmetric Difference: " + diff1);
    }
}
