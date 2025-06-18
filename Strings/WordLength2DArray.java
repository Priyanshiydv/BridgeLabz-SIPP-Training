import java.util.Scanner;

public class WordLength2DArray {

    static String[] splitWords(String text) {
        String[] words = new String[100];
        int index = 0;
        StringBuilder word = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch != ' ') {
                word.append(ch);
            } else if (word.length() > 0) {
                words[index++] = word.toString();
                word = new StringBuilder();
            }
        }
        if (word.length() > 0) {
            words[index++] = word.toString();
        }

        String[] result = new String[index];
        System.arraycopy(words, 0, result, 0, index);
        return result;
    }

    static int getLength(String word) {
        int count = 0;
        for (char c : word.toCharArray()) count++;
        return count;
    }

    static String[][] getWordLengthPairs(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    static void display2DArray(String[][] data) {
        System.out.println("\nWord\tLength");
        System.out.println("---------------");
        for (String[] row : data) {
            System.out.println(row[0] + "\t" + Integer.parseInt(row[1]));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = splitWords(text);
        String[][] wordLengthArray = getWordLengthPairs(words);
        display2DArray(wordLengthArray);
    }
}
