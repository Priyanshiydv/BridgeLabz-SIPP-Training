import java.util.Scanner;

public class FriendsInfo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Arrays for names, ages, and heights
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        // Input age and height for each friend
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter details for " + names[i] + ":");

            // Input age
            System.out.print("Enter age: ");
            ages[i] = sc.nextInt();

            // Input height
            System.out.print("Enter height in cm: ");
            heights[i] = sc.nextDouble();
        }

        // Step 2: Find youngest and tallest
        int youngestIndex = 0;
        int tallestIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }

        // Step 3: Display result
        System.out.println("\nResults:");
        System.out.println("Youngest friend is: " + names[youngestIndex] + " (Age: " + ages[youngestIndex] + ")");
        System.out.println("Tallest friend is: " + names[tallestIndex] + " (Height: " + heights[tallestIndex] + " cm)");
    }
}
