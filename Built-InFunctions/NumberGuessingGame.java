import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int lowerBound = 1;
        int upperBound = 100;
        boolean found = false;

        System.out.println("Think of a number between 1 and 100. I will try to guess it!");

        while (!found && lowerBound <= upperBound) {
            int guess = generateGuess(lowerBound, upperBound, random);
            System.out.println("Is your number " + guess + "? (Enter: high / low / correct)");
            String feedback = scanner.nextLine().toLowerCase();

            switch (feedback) {
                case "high":
                    upperBound = guess - 1;
                    break;
                case "low":
                    lowerBound = guess + 1;
                    break;
                case "correct":
                    System.out.println("Hooray! I guessed your number.");
                    found = true;
                    break;
                default:
                    System.out.println("Invalid input. Please enter 'high', 'low', or 'correct'.");
            }
        }

        if (!found) {
            System.out.println("Looks like there's been a mistake. Let's play again!");
        }
        scanner.close();
    }

    
    public static int generateGuess(int lower, int upper, Random random) {
        return random.nextInt(upper - lower + 1) + lower;
    }
}
