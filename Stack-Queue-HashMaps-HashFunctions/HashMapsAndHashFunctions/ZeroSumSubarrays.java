import java.util.*;

public class ZeroSumSubarrays {
    static void findSubarrays(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;

        map.put(0, new ArrayList<>());
        map.get(0).add(-1); // Handle subarray from index 0

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int start : map.get(sum)) {
                    System.out.println("Subarray: " + (start + 1) + " to " + i);
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, -7, 1, 3, -4, -2, -2};
        findSubarrays(arr);
    }
}
