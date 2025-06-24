import java.util.Scanner;

public class StudentScorecard {

    // Method 1: Generate random 2-digit PCM scores
    public static int[][] generateMarks(int numStudents) {
        int[][] marks = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            marks[i][0] = 30 + (int)(Math.random() * 70); // Physics
            marks[i][1] = 30 + (int)(Math.random() * 70); // Chemistry
            marks[i][2] = 30 + (int)(Math.random() * 70); // Math
        }
        return marks;
    }

    // Method 2: Calculate total, average, percentage
    public static double[][] calculateResults(int[][] marks) {
        int numStudents = marks.length;
        double[][] result = new double[numStudents][3]; // total, average, percentage

        for (int i = 0; i < numStudents; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double avg = total / 3.0;
            double percentage = (total / 300.0) * 100;

            result[i][0] = total;
            result[i][1] = Math.round(avg * 100.0) / 100.0;
            result[i][2] = Math.round(percentage * 100.0) / 100.0;
        }

        return result;
    }

    // Method 3: Assign grade and remarks
    public static String[][] assignGradesAndRemarks(double[][] results) {
        int n = results.length;
        String[][] grades = new String[n][2]; // [grade, remark]

        for (int i = 0; i < n; i++) {
            double percent = results[i][2];
            if (percent >= 80) {
                grades[i][0] = "A";
                grades[i][1] = "Level 4, above agency-normalized standards";
            } else if (percent >= 70) {
                grades[i][0] = "B";
                grades[i][1] = "Level 3, at agency-normalized standards";
            } else if (percent >= 60) {
                grades[i][0] = "C";
                grades[i][1] = "Level 2, below, but approaching agency-normalized standards";
            } else if (percent >= 50) {
                grades[i][0] = "D";
                grades[i][1] = "Level 1, well below agency-normalized standards";
            } else if (percent >= 40) {
                grades[i][0] = "E";
                grades[i][1] = "Level 1-, too below agency-normalized standards";
            } else {
                grades[i][0] = "R";
                grades[i][1] = "Remedial standards";
            }
        }

        return grades;
    }

    // Method 4: Display full scorecard
    public static void displayScorecard(int[][] marks, double[][] results, String[][] grades) {
        System.out.printf("\n%-8s %-8s %-8s %-8s %-8s %-10s %-10s %-6s %s\n",
            "Student", "Physics", "Chem", "Math", "Total", "Average", "Percent", "Grade", "Remarks");
        System.out.println("-----------------------------------------------------------------------------------------------");

        for (int i = 0; i < marks.length; i++) {
            System.out.printf("%-8s %-8d %-8d %-8d %-8.0f %-10.2f %-10.2f %-6s %s\n",
                "Stud" + (i + 1),
                marks[i][0], marks[i][1], marks[i][2],
                results[i][0], results[i][1], results[i][2],
                grades[i][0], grades[i][1]
            );
        }
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = generateMarks(n);
        double[][] results = calculateResults(marks);
        String[][] grades = assignGradesAndRemarks(results);
        displayScorecard(marks, results, grades);
    }
}
