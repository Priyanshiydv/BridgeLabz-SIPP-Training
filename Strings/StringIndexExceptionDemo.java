import java.util.Scanner;

public class StringIndexExceptionDemo {

    // Method to generate StringIndexOutOfBoundsException
    public static void generateException(String text) {
        // Accessing beyond string length
        char ch = text.charAt(text.length()); // This will throw exception
        System.out.println("Character at out-of-bound index: " + ch);
    }

    // Method to handle the exception with try-catch
    public static void handleException(String text) {
        try {
            char ch = text.charAt(text.length()); // Out of bounds
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = scanner.next();

        // Uncomment to see abrupt termination
        // generateException(text);

        // Safe handling
        handleException(text);
    }
}
