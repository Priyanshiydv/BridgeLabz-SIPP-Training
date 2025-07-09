public class SelectionSortExamScores {

    public static void main(String[] args) {
        int[] scores = {78, 92, 55, 68, 89, 73};

        System.out.println("Original Exam Scores:");
        printArray(scores);

        // Apply Selection Sort
        selectionSort(scores);

        System.out.println("\nSorted Exam Scores (Ascending Order):");
        printArray(scores);
    }

    // Selection Sort method
    public static void selectionSort(int[] arr) {
        int n = arr.length;

        // One by one move boundary of unsorted part
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            // Find index of minimum element in unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum with the first unsorted element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int score : arr) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
}
