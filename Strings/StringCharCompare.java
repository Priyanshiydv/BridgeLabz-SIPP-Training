import java.util.Scanner;

public class StringCharCompare {

    
    public static char[] getCharsFromString(String input) {
        char[] result = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            result[i] = input.charAt(i);
        }
        return result;
    }

    
    public static boolean compareCharArrays(char[] a, char[] b) {
        if (a.length != b.length) return false;

        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] userDefinedArray = getCharsFromString(text);
        char[] builtInArray = text.toCharArray();

        System.out.print("User-defined char array: ");
        for (char c : userDefinedArray) {
            System.out.print(c + " ");
        }

        System.out.print("\nBuilt-in toCharArray(): ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        boolean areEqual = compareCharArrays(userDefinedArray, builtInArray);
        System.out.println("\nAre both arrays equal? " + areEqual);
    }
}
