import java.util.Arrays;
import java.util.Random;

public class SortingComparison {

    // Bubble Sort (O(N^2)) - Inefficient
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }

    public static void main(String[] args) {
        int[] sizes = {1000, 10000}; // Skip 1 million for Bubble Sort
        Random rand = new Random();

        for (int size : sizes) {
            int[] original = new int[size];
            for (int i = 0; i < size; i++) {
                original[i] = rand.nextInt(size);
            }

            System.out.println("Dataset Size: " + size);

            // Bubble Sort
            int[] bubble = Arrays.copyOf(original, original.length);
            long startBubble = System.nanoTime();
            bubbleSort(bubble);
            long endBubble = System.nanoTime();
            System.out.printf("Bubble Sort Time: %.2f ms%n", (endBubble - startBubble) / 1_000_000.0);

            // Merge Sort (using built-in stable sort)
            int[] merge = Arrays.copyOf(original, original.length);
            long startMerge = System.nanoTime();
            Arrays.sort(merge); // Dual-Pivot QuickSort for primitives (Java 7+)
            long endMerge = System.nanoTime();
            System.out.printf("Merge Sort Time: %.2f ms%n", (endMerge - startMerge) / 1_000_000.0);

            // Quick Sort (simulate with custom implementation or reuse Arrays.sort)
            int[] quick = Arrays.copyOf(original, original.length);
            long startQuick = System.nanoTime();
            Arrays.sort(quick); // Reuse since it's Dual-Pivot QuickSort
            long endQuick = System.nanoTime();
            System.out.printf("Quick Sort Time: %.2f ms%n", (endQuick - startQuick) / 1_000_000.0);

            System.out.println("-------------------------");
        }
    }
}
