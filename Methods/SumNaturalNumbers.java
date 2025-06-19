import java.util.Scanner;

public class SumNaturalNumbers {

    public static int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number (n): ");
        int n = sc.nextInt();

        int result = sumOfNaturalNumbers(n);
        System.out.println("Sum of first " + n + " natural numbers is: " + result);
    }
}
