import java.util.Scanner;

public class RemoveDuplicates {

    public static String removeDuplicates(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (result.indexOf(str.charAt(i)) == -1)
                result += str.charAt(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with duplicates: ");
        String input = sc.nextLine();
        System.out.println("String after removing duplicates: " + removeDuplicates(input));
    }
}
