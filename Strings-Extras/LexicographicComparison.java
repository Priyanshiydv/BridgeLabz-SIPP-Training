import java.util.Scanner;

public class LexicographicComparison {

    public static int compareStrings(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());

        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return s1.charAt(i) - s2.charAt(i);
        }
        return s1.length() - s2.length();  // If all characters matched till the end of shorter string
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();
        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        int result = compareStrings(s1, s2);

        if (result == 0)
            System.out.println("Both strings are equal.");
        else if (result < 0)
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order.");
        else
            System.out.println("\"" + s2 + "\" comes before \"" + s1 + "\" in lexicographical order.");
    }
}
