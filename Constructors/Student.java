public class Student {
    public int rollNumber;
    protected String name;
    private double CGPA;

    // Constructor
    Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.CGPA = CGPA;
    }

    // Public methods to access CGPA
    public double getCGPA() {
        return CGPA;
    }

    public void setCGPA(double CGPA) {
        this.CGPA = CGPA;
    }

    // Add this main method to run the program
    public static void main(String[] args) {
        Student student = new Student(101, "Priya", 9.0);
        System.out.println("Roll Number: " + student.rollNumber);
        System.out.println("Name: " + student.name);
        System.out.println("CGPA: " + student.getCGPA());

        // Modify CGPA
        student.setCGPA(9.5);
        System.out.println("Updated CGPA: " + student.getCGPA());
    }
}
