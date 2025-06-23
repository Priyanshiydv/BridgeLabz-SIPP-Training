import java.util.Random;
import java.util.Scanner;

public class StudentVotingCheck {

    static int[] generateRandomAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        for (int i = 0; i < n; i++) {
            ages[i] = rand.nextInt(90);  // random age from 0 to 89
        }
        return ages;
    }

    static String[][] getVotingStatus(int[] ages) {
        String[][] result = new String[ages.length][2];

        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);

            if (ages[i] < 0) {
                result[i][1] = "false"; // Invalid
            } else if (ages[i] >= 18) {
                result[i][1] = "true";
            } else {
                result[i][1] = "false";
            }
        }
        return result;
    }

    static void displayVotingTable(String[][] data) {
        System.out.println("\nAge\tCan Vote");
        System.out.println("-----------------");
        for (String[] row : data) {
            System.out.println(Integer.parseInt(row[0]) + "\t" + row[1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = generateRandomAges(n);
        String[][] voteStatus = getVotingStatus(ages);
        displayVotingTable(voteStatus);
    }
}
