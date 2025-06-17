import java.util.Scanner;

public class LargestDigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input number
        System.out.print("Enter a positive number: ");
        int number = sc.nextInt();

        if (number <= 0) {
            System.out.println("Invalid input! Enter a positive number.");
            return;
        }

        // Step 2: Define array and maxDigit limit
        int maxDigit = 10;
        int[] digits = new int[maxDigit];

        // Step 3: Index variable
        int index = 0;

        // Step 4–6: Extract digits
        while (number != 0) {
            int digit = number % 10;
            digits[index] = digit;
            index++;

            number /= 10;

            if (index == maxDigit) {
                System.out.println("Only first 10 digits are considered.");
                break;
            }
        }

        // Step 7: Variables for largest and second largest
        int largest = -1;
        int secondLargest = -1;

        // Step 8: Loop to find largest and second largest
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
        System.out.println("\nDigits in the number:");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\n\nLargest digit: " + largest);
        if (secondLargest != -1)
            System.out.println("Second largest digit: " + secondLargest);
        else
            System.out.println("No second largest digit found.");
    }
}
