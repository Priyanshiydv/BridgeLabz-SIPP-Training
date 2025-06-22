import java.util.Scanner;

public class PalindromeCheck {

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int start = 0, end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string to check palindrome: ");
        String input = sc.nextLine();

        if (isPalindrome(input))
            System.out.println("The string is a palindrome.");
        else
            System.out.println("The string is NOT a palindrome.");
    }
}
