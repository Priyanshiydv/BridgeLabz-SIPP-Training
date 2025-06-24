import java.util.Scanner;

public class UppercaseConverter {

    // Convert to uppercase manually using ASCII
    public static String toUpperCaseCustom(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char) (ch - 32);  // Convert to uppercase
            } else {
                result += ch;  // Keep as-is
            }
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
        System.out.print("Enter your text: ");
        String text = scanner.nextLine();

        String builtInUpper = text.toUpperCase();              // Using built-in
        String customUpper = toUpperCaseCustom(text);          // Using custom method

        System.out.println("Built-in uppercase: " + builtInUpper);
        System.out.println("Custom uppercase:   " + customUpper);

        boolean isSame = compareStrings(builtInUpper, customUpper);
        System.out.println("Are both uppercase versions equal? " + isSame);
    }
}
