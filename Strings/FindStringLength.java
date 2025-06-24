import java.util.Scanner;

public class FindStringLength {

    static int getCustomLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // String index out of bounds, stop
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();

        int customLength = getCustomLength(input);
        int builtInLength = input.length();

        System.out.println("Built-in length(): " + builtInLength);
        System.out.println("User-defined length: " + customLength);
    }
}
