public class InsertionSortEmployeeIDs {

    public static void main(String[] args) {
        // Unsorted array of Employee IDs
        int[] employeeIDs = {1025, 1001, 1042, 1010, 1033};

        System.out.println("Original Employee IDs:");
        printArray(employeeIDs);

        // Call insertion sort method
        insertionSort(employeeIDs);

        System.out.println("\nSorted Employee IDs (Ascending Order):");
        printArray(employeeIDs);
    }

    // Method to perform insertion sort
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from the second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Element to be inserted
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift element right
                j--;
            }

            // Insert key at its correct position
            arr[j + 1] = key;
        }
    }

    // Method to print array elements
    public static void printArray(int[] arr) {
        for (int id : arr) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
}
