import java.util.*;

public class LongestConsecutiveSeq {
    static int longestSequence(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        int maxLength = 0;

        for (int num : arr) {
            // Only start when it's the beginning of a sequence
            if (!set.contains(num - 1)) {
                int curr = num;
                int length = 1;

                while (set.contains(curr + 1)) {
                    curr++;
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest Sequence Length: " + longestSequence(arr)); // Output: 4
    }
}
