import java.util.Scanner;

public class StudentsGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Step 2: Create arrays
        int[][] marks = new int[n][3]; // 0 = Physics, 1 = Chemistry, 2 = Maths
        double[] percentages = new double[n];
        String[] grades = new String[n];

        // Step 3: Take input of marks
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";

                System.out.print(subject + ": ");
                int mark = sc.nextInt();

                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid marks! Enter between 0 and 100.");
                    j--; // Repeat input for same subject
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        // Step 4: Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3.0;

            // Grade logic
            if (percentages[i] >= 90)
                grades[i] = "A+";
            else if (percentages[i] >= 80)
                grades[i] = "A";
            else if (percentages[i] >= 70)
                grades[i] = "B";
            else if (percentages[i] >= 60)
                grades[i] = "C";
            else if (percentages[i] >= 50)
                grades[i] = "D";
            else
                grades[i] = "F";
        }

        // Step 5: Display results
        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-12s %-6s\n", "Student", "Physics", "Chemistry", "Maths", "Percent(%)", "Grade");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d %-10d %-10d %-10d %-12.2f %-6s\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
