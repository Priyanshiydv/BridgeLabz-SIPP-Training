public class QuickSortProductPrices {

    public static void main(String[] args) {
        int[] prices = {999, 499, 1299, 299, 899, 149};

        System.out.println("Original Product Prices:");
        printArray(prices);

        // Apply Quick Sort
        quickSort(prices, 0, prices.length - 1);

        System.out.println("\nSorted Product Prices (Ascending Order):");
        printArray(prices);
    }

    // Quick Sort method
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get pivot index
            int pivotIndex = partition(arr, low, high);

            // Recursively sort left and right of pivot
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Partition method
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];  // Choosing last element as pivot
        int i = low - 1;

        // Compare each element with pivot
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1; // Return pivot index
    }

    // Utility to print array
    public static void printArray(int[] arr) {
        for (int price : arr) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
}
