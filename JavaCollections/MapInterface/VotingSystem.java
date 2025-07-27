import java.util.*;

public class VotingSystem {

    // HashMap to store current vote count per candidate
    private Map<String, Integer> voteMap = new HashMap<>();

    // LinkedHashMap to store first-time vote order
    private Map<String, Integer> linkedVoteMap = new LinkedHashMap<>();

    // Method to cast a vote
    public void castVote(String candidate) {
        // Increment vote in HashMap
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);

        // Record first-time vote in LinkedHashMap
        if (!linkedVoteMap.containsKey(candidate)) {
            linkedVoteMap.put(candidate, 1);
        }
    }

    // Display raw vote data (unordered)
    public void displayVotesUnordered() {
        System.out.println("\nVotes (Unordered - HashMap):");
        for (Map.Entry<String, Integer> entry : voteMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    // Display vote data in alphabetical order (TreeMap)
    public void displayVotesAlphabetical() {
        System.out.println("\nVotes (Sorted by Candidate Name - TreeMap):");
        TreeMap<String, Integer> sortedMap = new TreeMap<>(voteMap);
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }

    // Display vote order by first appearance
    public void displayFirstVoteOrder() {
        System.out.println("\nFirst Vote Order (LinkedHashMap):");
        for (Map.Entry<String, Integer> entry : linkedVoteMap.entrySet()) {
            System.out.println(entry.getKey() + " (first voted)");
        }
    }

    public static void main(String[] args) {
        VotingSystem system = new VotingSystem();

        // Simulate casting votes
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Charlie");
        system.castVote("Alice");
        system.castVote("Bob");
        system.castVote("Alice");

        // Display results
        system.displayVotesUnordered();
        system.displayVotesAlphabetical();
        system.displayFirstVoteOrder();
    }
}
