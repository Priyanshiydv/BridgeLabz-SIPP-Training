import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a date (yyyy-MM-dd): ");
        String inputDate = scanner.nextLine();

        
        LocalDate date = LocalDate.parse(inputDate);

        
        LocalDate modifiedDate = date.plusDays(7).plusMonths(1).plusYears(2);

        
        modifiedDate = modifiedDate.minusWeeks(3);

        
        System.out.println("Final Date after arithmetic: " + modifiedDate);
        
        scanner.close();
    }
}
