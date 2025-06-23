public class NullPointerDemo {

    // Method to generate NullPointerException
    public static void generateException() {
        String text = null;
        System.out.println("Length of text: " + text.length());  // Will throw exception
    }

    // Method to handle NullPointerException
    public static void handleException() {
        try {
            String text = null;
            System.out.println("Length of text: " + text.length());
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Generic RuntimeException caught: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Uncomment to generate and crash
        // generateException();

        // Handle safely
        handleException();
    }
}
