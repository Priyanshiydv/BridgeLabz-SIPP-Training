import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            // Using formula
            int formulaSum = n * (n + 1) / 2;

            // Using for loop
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            System.out.println("Sum using loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);

            if (loopSum == formulaSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("There is a mismatch in the results.");
            }
        }
    }
}
