public class MergeSortBookPrices {

    public static void main(String[] args) {
        // Array of unsorted book prices
        int[] bookPrices = {499, 150, 799, 299, 650, 120};

        System.out.println("Original Book Prices:");
        printArray(bookPrices);

        // Call merge sort method
        mergeSort(bookPrices, 0, bookPrices.length - 1);

        System.out.println("\nSorted Book Prices (Ascending Order):");
        printArray(bookPrices);
    }

    // Recursive merge sort method
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            // Find the middle point
            int mid = (left + right) / 2;

            // Recursively sort first and second halves
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            // Merge the sorted halves
            merge(arr, left, mid, right);
        }
    }

    // Method to merge two sorted halves
    public static void merge(int[] arr, int left, int mid, int right) {
        // Sizes of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Temporary arrays
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArr[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            rightArr[j] = arr[mid + 1 + j];

        // Initial indexes for merging
        int i = 0, j = 0, k = left;

        // Merge the temp arrays into original array
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        // Copy remaining elements from leftArr if any
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        // Copy remaining elements from rightArr if any
        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }

    // Method to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
