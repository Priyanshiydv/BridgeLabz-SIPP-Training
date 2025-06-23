import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Step 1: Take input for number of students
        System.out.print("Enter the number of students: ");
        int n = sc.nextInt();

        // Step 2: Create arrays
        double[][] marks = new double[n][3]; // 0 = Physics, 1 = Chemistry, 2 = Maths
        double[] percentages = new double[n];
        String[] grades = new String[n];

        // Step 3: Input marks for each student
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                System.out.print(subject + " marks: ");
                double mark = sc.nextDouble();

                // Check for negative marks
                if (mark < 0 || mark > 100) {
                    System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                    j--; // repeat this subject input
                } else {
                    marks[i][j] = mark;
                }
            }
        }

        // Step 4: Calculate percentage and grade
        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percentages[i] = total / 3;

            // Grade calculation
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
            System.out.printf("%-10d %-10.2f %-10.2f %-10.2f %-12.2f %-6s\n",
                    (i + 1), marks[i][0], marks[i][1], marks[i][2], percentages[i], grades[i]);
        }
    }
}
