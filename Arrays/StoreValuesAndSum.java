import java.util.Scanner;

public class StoreValuesAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        System.out.println("Enter up to 10 positive numbers (enter 0 or a negative number to stop):");

        while (true) {
            System.out.print("Enter number " + (index + 1) + ": ");
            double input = scanner.nextDouble();

            // Check if input is 0 or negative → break the loop
            if (input <= 0) {
                break;
            }

            numbers[index] = input;
            index++;

            // Break the loop if 10 numbers have been entered
            if (index == 10) {
                break;
            }
        }

        System.out.println("\nNumbers entered:");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\nSum of all numbers = " + total);

        scanner.close();
    }
}
