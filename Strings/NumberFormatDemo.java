import java.util.Scanner;

public class NumberFormatDemo {

    // Method to generate NumberFormatException
    public static void generateNumberFormatException(String input) {
        // This will throw NumberFormatException if input is not a valid number
        int number = Integer.parseInt(input); 
        System.out.println("Converted number: " + number);
    }

    // Method to handle NumberFormatException
    public static void handleNumberFormatException(String input) {
        try {
            int number = Integer.parseInt(input);
            System.out.println("Handled number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value (not a number): ");
        String input = scanner.next();

        // This call will throw an exception and stop the program
        // Uncomment to test exception generation
        // generateNumberFormatException(input);

        // This call will handle the exception gracefully
        handleNumberFormatException(input);
    }
}
