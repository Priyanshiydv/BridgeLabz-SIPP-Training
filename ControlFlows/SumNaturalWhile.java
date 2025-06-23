import java.util.Scanner;

public class SumNaturalWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("The number " + n + " is not a natural number.");
        } else {
            
            int formulaSum = n * (n + 1) / 2;

            
            int count = 1;
            int loopSum = 0;

            while (count <= n) {
                loopSum += count;
                count++;
            }

            
            System.out.println("Sum using while loop: " + loopSum);
            System.out.println("Sum using formula: " + formulaSum);

            if (loopSum == formulaSum) {
                System.out.println("Both computations are correct.");
            } else {
                System.out.println("Mismatch in results.");
            }
        }
    }
}
