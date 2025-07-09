public class BubbleSortStudentMarks {

    public static void main(String[] args) {
        // Sample array of student marks
        int[] marks = {75, 60, 85, 90, 45, 70};

        System.out.println("Original Marks:");
        printArray(marks);

        // Call bubble sort method
        bubbleSort(marks);

        System.out.println("\nSorted Marks (Ascending Order):");
        printArray(marks);
    }

    // Method to perform bubble sort on the array
    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - 1 - i; j++) {

                // If current element is greater than next, swap them
                if (arr[j] > arr[j + 1]) {
                    // Swapping using a temporary variable
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Method to print array elements
    public static void printArray(int[] arr) {
        for (int mark : arr) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
}
