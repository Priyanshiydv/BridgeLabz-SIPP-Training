import java.util.Scanner;

public class MostFrequentCharacter {

    public static char findMostFrequentChar(String str) {
        int[] freq = new int[256]; // For ASCII characters
        str = str.toLowerCase();

        for (char ch : str.toCharArray()) {
            freq[ch]++;
        }

        int max = 0;
        char result = ' ';
        for (char ch : str.toCharArray()) {
            if (freq[ch] > max) {
                max = freq[ch];
                result = ch;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Most Frequent Character: '" + findMostFrequentChar(input) + "'");
    }
}
