import java.util.*;

public class ListRotator {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 20, 30, 40, 50));
        int k = 2;

        int n = list.size();
        k = k % n;

        // Store rotated result
        List<Integer> rotated = new ArrayList<>();
        rotated.addAll(list.subList(k, n)); // Elements after kth
        rotated.addAll(list.subList(0, k)); // First k elements

        // Copy back to original list
        for (int i = 0; i < n; i++) {
            list.set(i, rotated.get(i));
        }

        System.out.println("List after rotating by " + k + " positions: " + list);
    }
}
