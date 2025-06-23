import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();

        int count = 0;
        int temp = number;

        if (number == 0) {
            count = 1;
        } else {
            while (temp != 0) {
                temp = temp / 10; // Remove last digit
                count++;
            }
        }

        System.out.println("The number of digits in " + number + " is: " + count);
    }
}
