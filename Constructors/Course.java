// Course class with instance and class variables/methods
class Course {
    // Instance variables (unique to each object)
    String courseName;
    int duration; // in months
    double fee;

    // Class variable (shared among all Course objects)
    static String instituteName = "ABC Learning Center";

    // Constructor to initialize course details
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    // Instance method to display course details
    void displayCourseDetails() {
        System.out.println("Institute: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: ₹" + fee);
        System.out.println("---------------------------");
    }

    // Class (static) method to update institute name
    static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
    }

    public static void main(String[] args) {
        Course c1 = new Course("Java Programming", 3, 6000);
        Course c2 = new Course("Web Development", 4, 8000);

        // Display before updating institute name
        c1.displayCourseDetails();
        c2.displayCourseDetails();

        // Update institute name (affects all Course objects)
        Course.updateInstituteName("XYZ Tech Academy");

        // Display after updating institute name
        c1.displayCourseDetails();
        c2.displayCourseDetails();
    }
}
