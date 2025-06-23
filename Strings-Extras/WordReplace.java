import java.util.Scanner;

public class WordReplace {

    public static String replaceWord(String sentence, String oldWord, String newWord) {
        return sentence.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String sentence = sc.nextLine();
        System.out.print("Enter word to replace: ");
        String oldWord = sc.next();
        System.out.print("Enter new word: ");
        String newWord = sc.next();

        System.out.println("Modified Sentence: " + replaceWord(sentence, oldWord, newWord));
    }
}
