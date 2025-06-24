import java.util.Scanner;

public class WordLengthAnalyzer {

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
        int length = 0;
        for (char c : word.toCharArray()) {
            length++;
        }
        return length;
    }

    static String[][] wordLengthPairs(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(getLength(words[i]));
        }
        return result;
    }

    static int[] findMinMaxLengthIndex(String[][] wordLengthArray) {
        int minIdx = 0, maxIdx = 0;
        int minLen = Integer.parseInt(wordLengthArray[0][1]);
        int maxLen = Integer.parseInt(wordLengthArray[0][1]);

        for (int i = 1; i < wordLengthArray.length; i++) {
            int len = Integer.parseInt(wordLengthArray[i][1]);
            if (len < minLen) {
                minLen = len;
                minIdx = i;
            }
            if (len > maxLen) {
                maxLen = len;
                maxIdx = i;
            }
        }
        return new int[]{minIdx, maxIdx};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] words = splitWords(input);
        String[][] wordLengthArray = wordLengthPairs(words);
        int[] minMax = findMinMaxLengthIndex(wordLengthArray);

        System.out.println("\nWords with Lengths:");
        for (String[] pair : wordLengthArray) {
            System.out.println(pair[0] + " : " + pair[1]);
        }

        System.out.println("\nShortest Word: " + wordLengthArray[minMax[0]][0]);
        System.out.println("Longest Word: " + wordLengthArray[minMax[1]][0]);
    }
}
