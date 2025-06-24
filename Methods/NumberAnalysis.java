import java.util.Scanner;

public class NumberAnalysis {

    public static boolean isPositive(int num) {
        return num >= 0;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static int compare(int num1, int num2) {
        if (num1 > num2) return 1;
        else if (num1 == num2) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }

        for (int num : numbers) {
            if (isPositive(num)) {
                System.out.print(num + " is Positive and ");
                System.out.println(isEven(num) ? "Even" : "Odd");
            } else {
                System.out.println(num + " is Negative");
            }
        }

        int result = compare(numbers[0], numbers[4]);
        System.out.print("Comparison of first and last element: ");
        if (result == 0)
            System.out.println("They are Equal.");
        else if (result == 1)
            System.out.println("First element is Greater than Last.");
        else
            System.out.println("First element is Less than Last.");
    }
}
