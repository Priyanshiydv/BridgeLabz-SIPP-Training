import java.util.Scanner;

public class TrimSpaces {

    // Method to find start and end index after trimming
    public static int[] getTrimBounds(String text) {
        int start = 0, end = text.length() - 1;

        // Skip leading spaces
        while (start <= end && text.charAt(start) == ' ') {
            start++;
        }

        // Skip trailing spaces
        while (end >= start && text.charAt(end) == ' ') {
            end--;
        }

        return new int[]{start, end + 1};  // end is exclusive
    }

    // Create substring manually using charAt
    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    // Compare strings character by character
    public static boolean compareStrings(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text with leading/trailing spaces: ");
        String text = scanner.nextLine();

        int[] bounds = getTrimBounds(text);
        String customTrim = customSubstring(text, bounds[0], bounds[1]);
        String builtInTrim = text.trim();

        System.out.println("\nCustom trimmed:  '" + customTrim + "'");
        System.out.println("Built-in trimmed: '" + builtInTrim + "'");

        boolean isSame = compareStrings(customTrim, builtInTrim);
        System.out.println("Are both trims equal? " + isSame);
    }
}
