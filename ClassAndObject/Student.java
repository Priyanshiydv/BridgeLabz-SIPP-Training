// Class to represent a Student
class Student{
    String name;       // Student's name
    int rollNumber;    // Student's roll number
    int marks;         // Marks obtained by the student

    // Constructor to initialize student details
    Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    // Method to calculate grade based on marks
    String calculateGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "Fail";
    }

    // Method to display student details and grade
    void displayDetails() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Creating a Student object
        Student s = new Student("Priya", 101, 85);
        // Display student details
        s.displayDetails();
    }
}
