import java.util.*;

public class TwoSumIndices {
    static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>(); // num -> index

        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];
            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(arr, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // 0, 1
    }
}
