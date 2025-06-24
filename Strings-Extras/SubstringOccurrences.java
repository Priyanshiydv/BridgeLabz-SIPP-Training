import java.util.Scanner;

public class SubstringOccurrences {

    public static int countOccurrences(String str, String sub) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(sub, index)) != -1) {
            count++;
            index += sub.length();
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the main string: ");
        String mainString = sc.nextLine();
        System.out.print("Enter the substring to search: ");
        String substring = sc.nextLine();

        System.out.println("Occurrences: " + countOccurrences(mainString, substring));
    }
}
