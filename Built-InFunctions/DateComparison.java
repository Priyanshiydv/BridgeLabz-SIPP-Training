import java.time.LocalDate;
import java.util.Scanner;

public class DateComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the first date (yyyy-MM-dd): ");
        String firstDateInput = scanner.nextLine();
        LocalDate firstDate = LocalDate.parse(firstDateInput);

        
        System.out.print("Enter the second date (yyyy-MM-dd): ");
        String secondDateInput = scanner.nextLine();
        LocalDate secondDate = LocalDate.parse(secondDateInput);

        
        if (firstDate.isBefore(secondDate)) {
            System.out.println("The first date is BEFORE the second date.");
        } else if (firstDate.isAfter(secondDate)) {
            System.out.println("The first date is AFTER the second date.");
        } else if (firstDate.isEqual(secondDate)) {
            System.out.println("Both dates are the SAME.");
        }

        scanner.close();
    }
}
