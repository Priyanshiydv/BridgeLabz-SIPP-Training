public class CountingSortStudentAges {

    public static void main(String[] args) {
        // Student ages (ranging between 10 and 18)
        int[] ages = {15, 12, 18, 14, 11, 15, 10, 13, 12, 16};

        System.out.println("Original Student Ages:");
        printArray(ages);

        // Apply Counting Sort
        int[] sortedAges = countingSort(ages, 10, 18); // min = 10, max = 18

        System.out.println("\nSorted Student Ages (Ascending Order):");
        printArray(sortedAges);
    }

    // Counting Sort function for ages between min and max
    public static int[] countingSort(int[] arr, int min, int max) {
        int range = max - min + 1;  // Age range (e.g., 10 to 18 → size 9)

        int[] count = new int[range];     // To store frequency of each age
        int[] output = new int[arr.length]; // Sorted output array

        // Step 1: Count frequency of each age
        for (int age : arr) {
            count[age - min]++;
        }

        // Step 2: Compute cumulative frequency
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Build the output array (stable sort)
        for (int i = arr.length - 1; i >= 0; i--) {
            int age = arr[i];
            output[count[age - min] - 1] = age;
            count[age - min]--;
        }

        return output;
    }

    // Method to print array
    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
