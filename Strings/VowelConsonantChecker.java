import java.util.Scanner;

public class VowelConsonantChecker {

    // Method to check the type of character
    public static String getCharType(char ch) {
        // Convert to lowercase if uppercase
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char)(ch + 32); // A to a, B to b, etc.
        }

        // Check if it is a letter
        if (ch >= 'a' && ch <= 'z') {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to process the entire string and return 2D array of results
    public static String[][] analyzeString(String input) {
        int len = input.length();
        String[][] result = new String[len][2];

        for (int i = 0; i < len; i++) {
            char ch = input.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = getCharType(ch);
        }

        return result;
    }

    // Method to display results in a tabular format
    public static void displayResult(String[][] data) {
        System.out.printf("\n%-10s %-15s\n", "Character", "Type");
        System.out.println("------------------------------");
        for (String[] row : data) {
            System.out.printf("%-10s %-15s\n", row[0], row[1]);
        }
    }

    // Main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to analyze: ");
        String input = scanner.nextLine();

        String[][] result = analyzeString(input);
        displayResult(result);
    }
}
