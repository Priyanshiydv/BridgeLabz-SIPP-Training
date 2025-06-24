import java.util.Scanner;

public class FactorialWhileLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int num = scanner.nextInt();

        if (num < 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int factorial = 1;
            int i = 1;

            while (i <= num) {
                factorial *= i;
                i++;
            }

            System.out.println("Factorial of " + num + " is: " + factorial);
        }
    }
}
