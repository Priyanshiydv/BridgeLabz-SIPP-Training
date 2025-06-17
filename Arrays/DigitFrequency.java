import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Input number
        System.out.print("Enter a positive number: ");
        long number = sc.nextLong();

        if (number < 0) {
            System.out.println("Invalid input. Enter a positive number.");
            return;
        }

        // Step 2–4: Find frequency
        int[] frequency = new int[10]; // Index 0 to 9 for each digit

        while (number != 0) {
            int digit = (int)(number % 10);
            frequency[digit]++;
            number /= 10;
        }

        // Step 5: Display frequencies
        System.out.println("\nDigit Frequencies:");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0)
                System.out.println("Digit " + i + " => " + frequency[i] + " time(s)");
        }
    }
}
