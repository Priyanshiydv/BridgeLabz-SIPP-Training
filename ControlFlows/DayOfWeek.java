import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take month, day, and year as input
        System.out.print("Enter month (1 = Jan, ..., 12 = Dec): ");
        int m = scanner.nextInt();

        System.out.print("Enter day: ");
        int d = scanner.nextInt();

        System.out.print("Enter year: ");
        int y = scanner.nextInt();

        // Apply the formula
        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;

        // Print result
        System.out.println("Day of week (0=Sun, ..., 6=Sat): " + d0);
    }
}
