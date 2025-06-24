import java.util.Scanner;

public class MaximumOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = getNumber(scanner, "Enter first number: ");
        int num2 = getNumber(scanner, "Enter second number: ");
        int num3 = getNumber(scanner, "Enter third number: ");

        int max = findMaximum(num1, num2, num3);
        System.out.println("The maximum number is: " + max);

        scanner.close();
    }

    
    public static int getNumber(Scanner scanner, String prompt) {
        System.out.print(prompt);
        return scanner.nextInt();
    }

    
    public static int findMaximum(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
