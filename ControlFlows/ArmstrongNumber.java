import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Get integer input from the user
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // 2. Initialize sum to 0 and store original number for later comparison
        int sum = 0;
        int originalNumber = number;

        // 3. Use while loop till originalNumber is not equal to 0
        while (originalNumber != 0) {
            // 4. Get the last digit (remainder)
            int digit = originalNumber % 10;

            // 4. Find the cube of the digit and add it to sum
            sum += digit * digit * digit;

            // 5. Remove the last digit
            originalNumber = originalNumber / 10;
        }

        // 6. Compare the result with the original number
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is NOT an Armstrong Number.");
        }
    }
}
