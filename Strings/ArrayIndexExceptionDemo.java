import java.util.Scanner;

public class ArrayIndexExceptionDemo {

    
    public static void generateException(String[] names) {
        
        System.out.println("Accessing invalid index (will cause exception): " + names[names.length]);
    }

    
    public static void handleException(String[] names) {
        try {
            System.out.println("Trying to access invalid index...");
            System.out.println(names[names.length]); // Causes exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] names = new String[3];

        System.out.println("Enter 3 names:");
        for (int i = 0; i < 3; i++) {
            names[i] = sc.next();
        }

        
        handleException(names);
    }
}
