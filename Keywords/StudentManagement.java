public class StudentManagement {

    // Student class representing a university student
    static class Student {

        // Static variable shared by all students
        static String universityName = "Delhi University";

        // Static counter for total students
        private static int totalStudents = 0;

        // Final variable: roll number is constant for each student
        private final int rollNumber;

        // Instance variables
        private String name;
        private String grade;

        // Constructor using 'this' for clarity
        public Student(int rollNumber, String name, String grade) {
            this.rollNumber = rollNumber;
            this.name = name;
            this.grade = grade;
            totalStudents++;
        }

        // Static method to show student count
        public static void displayTotalStudents() {
            System.out.println("Total Students: " + totalStudents);
        }

        // Instance method to show student details
        public void displayStudentDetails() {
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("Grade: " + grade);
            System.out.println("University: " + universityName);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Raj", "A");
        Student s2 = new Student(2, "Simran", "B+");

        // Safe type checking
        if (s1 instanceof Student) s1.displayStudentDetails();
        if (s2 instanceof Student) s2.displayStudentDetails();

        Student.displayTotalStudents();
    }
}
