import java.util.*;

public class FrequencyCounter {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "banana", "apple", "orange");
        Map<String, Integer> freqMap = new HashMap<>();

        // Count frequencies
        for (String fruit : fruits) {
            freqMap.put(fruit, freqMap.getOrDefault(fruit, 0) + 1);
        }

        System.out.println("Frequency of elements: " + freqMap);
    }
}
