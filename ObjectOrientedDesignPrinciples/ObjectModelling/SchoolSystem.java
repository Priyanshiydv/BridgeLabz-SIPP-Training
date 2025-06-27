import java.util.*;

// Course class - has a list of students (many-to-many)
class Course {
    private String courseName;
    private List<Student> enrolledStudents = new ArrayList<>();

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : enrolledStudents) {
            System.out.println("- " + s.getName());
        }
    }

    public String getCourseName() {
        return courseName;
    }
}

// Student class - can enroll in multiple courses
class Student {
    private String name;
    private List<Course> enrolledCourses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
        course.enrollStudent(this); // maintain bidirectional relationship
    }

    public void showCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }

    public String getName() {
        return name;
    }
}

// School class - aggregates students
class School {
    private String schoolName;
    private List<Student> students = new ArrayList<>();

    public School(String name) {
        this.schoolName = name;
    }

    public void addStudent(Student student) {
        students.add(student); // aggregation: school contains students
    }

    public void showAllStudents() {
        System.out.println("Students in " + schoolName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

// Main class
public class SchoolSystem {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        // Create students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Create courses
        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");

        // School aggregates students
        school.addStudent(alice);
        school.addStudent(bob);

        // Students enroll in courses (association)
        alice.enrollInCourse(math);
        alice.enrollInCourse(physics);
        bob.enrollInCourse(physics);

        // Display data
        school.showAllStudents();
        System.out.println();

        alice.showCourses();
        bob.showCourses();
        System.out.println();

        math.showEnrolledStudents();
        physics.showEnrolledStudents();
    }
}
