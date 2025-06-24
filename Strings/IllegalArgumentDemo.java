import java.util.Scanner;

public class IllegalArgumentDemo {

    // Method to generate IllegalArgumentException
    public static void generateIllegalArgumentException(String text) {
        // This will throw IllegalArgumentException due to invalid substring indices
        String result = text.substring(5, 2); 
        System.out.println("Result: " + result);
    }

    // Method to handle IllegalArgumentException
    public static void handleIllegalArgumentException(String text) {
        try {
            String result = text.substring(5, 2);
            System.out.println("Handled result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.next();

        // Uncomment below line to generate unhandled exception
        // generateIllegalArgumentException(input);

        // This call will handle the exception gracefully
        handleIllegalArgumentException(input);
    }
}
