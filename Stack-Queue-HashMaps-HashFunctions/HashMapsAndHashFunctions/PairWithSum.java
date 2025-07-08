import java.util.*;

public class PairWithSum {
    static boolean hasPair(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (set.contains(complement)) {
                System.out.println("Pair: " + num + ", " + complement);
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 1, 6};
        int target = 10;
        System.out.println("Exists: " + hasPair(arr, target));
    }
}
