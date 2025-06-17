import java.util.Scanner;

public class LargestTwoDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a positive number: ");
        long number = sc.nextLong();

        if (number <= 0) {
            System.out.println("Invalid input. Enter a positive number.");
            return;
        }

        // Step 2: Define digit array with initial size 10
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        // Step 3: Index to track number of digits
        int index = 0;

        // Step 4–6: Extract digits and resize if needed
        while (number != 0) {
            int digit = (int) (number % 10);

            // If array is full, resize
            if (index == maxDigit) {
                maxDigit += 10; // increase size
                int[] temp = new int[maxDigit];

                // Copy old data to new array
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp;
            }

            digits[index++] = digit;
            number /= 10;
        }

        // Step 7: Initialize largest and second largest
        int largest = -1;
        int secondLargest = -1;

        // Step 8: Find largest and second largest digits
        for (int i = 0; i < index; i++) {
            int current = digits[i];

            if (current > largest) {
                secondLargest = largest;
                largest = current;
            } else if (current > secondLargest && current != largest) {
                secondLargest = current;
            }
        }

        // Step 9: Display results
        System.out.print("\nDigits: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\n\nLargest digit: " + largest);

        if (secondLargest != -1)
            System.out.println("Second largest digit: " + secondLargest);
        else
            System.out.println("No second largest digit found (all digits are same).");
    }
}
