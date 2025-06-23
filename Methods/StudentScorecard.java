import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    
    public static int[][] generateScores(int numStudents) {
        Random rand = new Random();
        int[][] scores = new int[numStudents][3]; // 3 subjects: Physics, Chemistry, Maths
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = rand.nextInt(101); // 0 to 100 inclusive
            }
        }
        return scores;
    }

    
    public static double[][] calculateStats(int[][] scores) {
        int numStudents = scores.length;
        double[][] stats = new double[numStudents][3];

        for (int i = 0; i < numStudents; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                total += scores[i][j];
            }
            double average = (double) total / 3;
            double percentage = (double) total / 300 * 100;

            
            average = Math.round(average * 100.0) / 100.0;
            percentage = Math.round(percentage * 100.0) / 100.0;

            stats[i][0] = total;
            stats[i][1] = average;
            stats[i][2] = percentage;
        }
        return stats;
    }

    
    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Student\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        for (int i = 0; i < scores.length; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < 3; j++) {
                System.out.print(scores[i][j] + "\t");
            }
            System.out.printf("%.0f\t%.2f\t%.2f\n", stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateStats(scores);

        System.out.println("\nScorecard:");
        displayScorecard(scores, stats);

        sc.close();
    }
}
