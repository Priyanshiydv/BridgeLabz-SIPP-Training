import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String text = "Hello world, hello Java!";

        // Convert to lowercase and remove punctuation
        text = text.toLowerCase().replaceAll("[^a-z\\s]", "");
        String[] words = text.split("\\s+");

        Map<String, Integer> wordCount = new HashMap<>();

        // Count each word
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        System.out.println("Word Frequencies: " + wordCount);
    }
}
