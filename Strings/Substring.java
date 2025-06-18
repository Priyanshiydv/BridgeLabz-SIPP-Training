import java.util.Scanner;

public class Substring {

    // Create substring using charAt()
    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end && i < text.length(); i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Compare two strings character by character
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = scanner.next();

        System.out.print("Enter start index: ");
        int start = scanner.nextInt();

        System.out.print("Enter end index: ");
        int end = scanner.nextInt();

        String builtInSub = text.substring(start, end);               // Using built-in
        String customSub = customSubstring(text, start, end);         // Using custom method

        System.out.println("Built-in substring: " + builtInSub);
        System.out.println("Custom substring:   " + customSub);

        boolean isEqual = compareStrings(builtInSub, customSub);
        System.out.println("Are both substrings equal? " + isEqual);
    }
}
