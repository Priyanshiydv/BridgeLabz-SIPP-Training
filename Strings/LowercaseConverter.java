import java.util.Scanner;

public class LowercaseConverter {

    // Convert uppercase to lowercase manually using ASCII
    public static String toLowerCaseCustom(String input) {
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                result += (char) (ch + 32);  // Convert to lowercase
            } else {
                result += ch;
            }
        }
        return result;
    }

    // Compare two strings using charAt
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

        String builtInLower = text.toLowerCase();
        String customLower = toLowerCaseCustom(text);

        System.out.println("Built-in lowercase: " + builtInLower);
        System.out.println("Custom lowercase:   " + customLower);

        boolean isSame = compareStrings(builtInLower, customLower);
        System.out.println("Are both lowercase versions equal? " + isSame);
    }
}
