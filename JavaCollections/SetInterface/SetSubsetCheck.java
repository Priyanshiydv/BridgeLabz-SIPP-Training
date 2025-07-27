import java.util.*;

public class SetSubsetCheck {
    public static void main(String[] args) {
        Set<Integer> subset = new HashSet<>(Arrays.asList(2, 3));
        Set<Integer> superset = new HashSet<>(Arrays.asList(1, 2, 3, 4));

        // containsAll() checks if all elements of one set are in another
        boolean isSubset = superset.containsAll(subset);

        System.out.println("Is subset? " + isSubset);
    }
}
