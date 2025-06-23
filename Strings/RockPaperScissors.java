import java.util.Scanner;

public class RockPaperScissors {

    // Get computer choice
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3); // 0, 1, or 2
        return switch (choice) {
            case 0 -> "rock";
            case 1 -> "paper";
            default -> "scissors";
        };
    }

    // Determine winner
    public static String getWinner(String player, String computer) {
        if (player.equals(computer)) return "Draw";
        return switch (player) {
            case "rock" -> (computer.equals("scissors")) ? "Player" : "Computer";
            case "paper" -> (computer.equals("rock")) ? "Player" : "Computer";
            case "scissors" -> (computer.equals("paper")) ? "Player" : "Computer";
            default -> "Invalid";
        };
    }

    // Display result table and stats
    public static void displayResults(String[][] results, int games) {
        int playerWins = 0, computerWins = 0, draws = 0;

        System.out.printf("\n%-10s %-10s %-10s\n", "Player", "Computer", "Winner");
        System.out.println("----------------------------------");

        for (String[] game : results) {
            System.out.printf("%-10s %-10s %-10s\n", game[0], game[1], game[2]);
            switch (game[2]) {
                case "Player" -> playerWins++;
                case "Computer" -> computerWins++;
                case "Draw" -> draws++;
            }
        }

        double playerPercent = (playerWins * 100.0) / games;
        double computerPercent = (computerWins * 100.0) / games;

        System.out.println("\n----- Game Stats -----");
        System.out.println("Total Games    : " + games);
        System.out.println("Player Wins    : " + playerWins + " (" + String.format("%.2f", playerPercent) + "%)");
        System.out.println("Computer Wins  : " + computerWins + " (" + String.format("%.2f", computerPercent) + "%)");
        System.out.println("Draws          : " + draws);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of games to play: ");
        int totalGames = scanner.nextInt();
        scanner.nextLine(); // consume newline

        String[][] gameResults = new String[totalGames][3];

        for (int i = 0; i < totalGames; i++) {
            System.out.print("\nEnter your choice (rock/paper/scissors): ");
            String playerChoice = scanner.nextLine().toLowerCase();

            String computerChoice = getComputerChoice();
            String winner = getWinner(playerChoice, computerChoice);

            gameResults[i][0] = playerChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;
        }

        displayResults(gameResults, totalGames);
    }
}
