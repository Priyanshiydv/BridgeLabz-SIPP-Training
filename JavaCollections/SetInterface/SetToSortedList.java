import java.util.*;

public class SetToSortedList {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        // Convert to list
        List<Integer> sortedList = new ArrayList<>(set);

        // Sort list in ascending order
        Collections.sort(sortedList);

        System.out.println("Sorted List: " + sortedList);
    }
}
