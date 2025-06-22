import java.util.Scanner;

class RemoveSpecificCharacter {

    public static String removeCharacter(String str, char toRemove) {
        StringBuilder result = new StringBuilder();

        for (char ch : str.toCharArray()) {
            if (ch != toRemove)
                result.append(ch);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        System.out.print("Enter character to remove: ");
        char ch = sc.next().charAt(0);

        System.out.println("Modified String: " + removeCharacter(input, ch));
    }
}
