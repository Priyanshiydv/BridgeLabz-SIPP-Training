import java.util.Scanner;

public class StringComparison {

    // Compare using charAt
    public static boolean compareByCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = scanner.next();

        System.out.print("Enter second string: ");
        String s2 = scanner.next();

        boolean charAtResult = compareByCharAt(s1, s2);
        boolean equalsResult = s1.equals(s2);

        System.out.println("Comparison using charAt(): " + charAtResult);
        System.out.println("Comparison using equals(): " + equalsResult);

        if (charAtResult == equalsResult) {
            System.out.println("Both methods returned the same result.");
        } else {
            System.out.println("Methods returned different results.");
        }
    }
}
