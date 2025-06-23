import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = getInput(scanner);
        boolean result = isPalindrome(input);

        displayResult(input, result);

        scanner.close();
    }

    
    public static String getInput(Scanner scanner) {
        System.out.print("Enter a string to check if it's a palindrome: ");
        return scanner.nextLine().toLowerCase().replaceAll("\\s+", "");
    }

    
    public static boolean isPalindrome(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }

    
    public static void displayResult(String input, boolean isPalindrome) {
        if (isPalindrome) {
            System.out.println("The input is a palindrome.");
        } else {
            System.out.println("The input is NOT a palindrome.");
        }
    }
}
