import java.util.*;

class Student {
    private String name;
    private List<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this); // bi-directional
        System.out.println(name + " enrolled in " + course.getCourseName());
    }

    public String getName() {
        return name;
    }

    public void showCourses() {
        System.out.println(name + "'s Enrolled Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public void assignToCourse(Course course) {
        course.setProfessor(this);
        System.out.println(name + " assigned to course " + course.getCourseName());
    }

    public String getName() {
        return name;
    }
}

class Course {
    private String courseName;
    private Professor professor;
    private List<Student> students = new ArrayList<>();

    public Course(String name) {
        this.courseName = name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setProfessor(Professor prof) {
        this.professor = prof;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Professor: " + (professor != null ? professor.getName() : "Not Assigned"));
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

public class UniversityManagementSystem {
    public static void main(String[] args) {
        Student s1 = new Student("Aman");
        Student s2 = new Student("Divya");

        Professor prof1 = new Professor("Dr. Mehta");

        Course javaCourse = new Course("Java Programming");

        s1.enrollCourse(javaCourse);
        s2.enrollCourse(javaCourse);

        prof1.assignToCourse(javaCourse);

        javaCourse.showCourseDetails();
    }
}
