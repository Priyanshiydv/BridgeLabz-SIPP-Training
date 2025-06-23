import java.util.Scanner;

public class ReverseNumberUsingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input
        System.out.print("Enter a positive number: ");
        long number = sc.nextLong();

        if (number < 0) {
            System.out.println("Invalid input. Enter a positive number.");
            return;
        }

        // Step 2–3: Store digits in an array
        int[] digits = new int[20]; // Assuming max 20 digits
        int index = 0;

        long temp = number;
        while (temp != 0) {
            digits[index] = (int)(temp % 10);
            temp /= 10;
            index++;
        }

        // Step 4–5: Display digits in reverse (already stored that way)
        System.out.print("Reversed Number: ");
        for (int i = 0; i < index; i++) {
            System.out.print(digits[i]);
        }
        System.out.println();
    }
}
