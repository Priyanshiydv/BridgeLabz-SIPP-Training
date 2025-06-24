import java.util.Scanner;

public class ToggleCase {

    public static String toggleCase(String str) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch))
                result.append(Character.toLowerCase(ch));
            else if (Character.isLowerCase(ch))
                result.append(Character.toUpperCase(ch));
            else
                result.append(ch);  // For spaces, digits, punctuation, etc.
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to toggle case: ");
        String input = sc.nextLine();

        System.out.println("Toggled Case: " + toggleCase(input));
    }
}
