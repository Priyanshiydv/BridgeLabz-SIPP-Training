import java.util.*;

public class SetEquality {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 2, 1));

        // equals() checks if both sets contain the same elements
        boolean areEqual = set1.equals(set2);

        System.out.println("Are the two sets equal? " + areEqual);
    }
}
