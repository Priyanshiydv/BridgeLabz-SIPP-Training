import java.util.Scanner;

public class WordSplitterCompare {

    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (Exception e) {
            // End of string
        }
        return count;
    }

    static String[] customSplit(String text) {
        int length = findLength(text);
        int wordCount = 0;

        // Count spaces
        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') wordCount++;
        }

        String[] words = new String[wordCount + 1];
        int start = 0, index = 0;

        for (int i = 0; i < length; i++) {
            if (text.charAt(i) == ' ') {
                words[index++] = getSubstring(text, start, i);
                start = i + 1;
            }
        }
        // Last word
        words[index] = getSubstring(text, start, length);
        return words;
    }

    static String getSubstring(String text, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    static boolean compareArrays(String[] arr1, String[] arr2) {
        if (arr1.length != arr2.length) return false;

        for (int i = 0; i < arr1.length; i++) {
            if (!arr1[i].equals(arr2[i])) return false;
        }
        return true;
    }

    static void displayWords(String[] arr, String label) {
        System.out.println("\nWords from " + label + ":");
        for (String word : arr) {
            System.out.println(word);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();

        String[] builtInSplit = input.split(" ");
        String[] customSplit = customSplit(input);

        displayWords(builtInSplit, "Built-in split()");
        displayWords(customSplit, "User-defined split");

        boolean areEqual = compareArrays(builtInSplit, customSplit);
        System.out.println("\nArrays are equal: " + areEqual);
    }
}
