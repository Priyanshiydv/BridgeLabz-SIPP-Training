import java.util.Arrays;
import java.util.Random;

public class SearchComparison {

    // Linear Search - O(N)
    public static int linearSearch(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) return i;
        }
        return -1;
    }

    // Binary Search - O(log N)
    public static int binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == key) return mid;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10_000, 1_000_000};
        int target = -1; // Make sure it's not in the array for worst-case testing

        for (int size : sizes) {
            int[] data = new int[size];
            Random rand = new Random();

            for (int i = 0; i < size; i++) {
                data[i] = rand.nextInt(size * 10); // Random values
            }

            // Linear Search
            long startLinear = System.nanoTime();
            linearSearch(data, target);
            long endLinear = System.nanoTime();
            double timeLinear = (endLinear - startLinear) / 1_000_000.0; // in ms

            // Binary Search (after sorting)
            Arrays.sort(data);
            long startBinary = System.nanoTime();
            binarySearch(data, target);
            long endBinary = System.nanoTime();
            double timeBinary = (endBinary - startBinary) / 1_000_000.0; // in ms

            // Output Results
            System.out.println("Dataset Size: " + size);
            System.out.printf("Linear Search Time: %.3f ms\n", timeLinear);
            System.out.printf("Binary Search Time: %.3f ms\n", timeBinary);
            System.out.println("-----------------------------");
        }
    }
}
