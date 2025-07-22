import java.util.*;

// === Abstract Base Class for Course Type ===
abstract class CourseType {
    private String title;
    private int credits;

    public CourseType(String title, int credits) {
        this.title = title;
        this.credits = credits;
    }

    public String getTitle() {
        return title;
    }

    public int getCredits() {
        return credits;
    }

    // Abstract method to describe evaluation type
    public abstract String getEvaluationType();

    @Override
    public String toString() {
        return title + " (" + getEvaluationType() + ") - Credits: " + credits;
    }
}

// === Subclasses Representing Different Evaluation Types ===
class ExamCourse extends CourseType {
    public ExamCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationType() {
        return "Exam-Based";
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationType() {
        return "Assignment-Based";
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String title, int credits) {
        super(title, credits);
    }

    @Override
    public String getEvaluationType() {
        return "Research-Based";
    }
}

// === Generic Course Class for Each Department ===
class Course<T extends CourseType> {
    private String departmentName;
    private List<T> courseList;

    public Course(String departmentName) {
        this.departmentName = departmentName;
        this.courseList = new ArrayList<>();
    }

    public void addCourse(T course) {
        courseList.add(course);
    }

    public List<T> getCourses() {
        return courseList;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    // Static method to display courses using wildcard
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType c : courses) {
            System.out.println(c);
        }
    }
}

// === Main Class to Test the System ===
public class UniversityCourseManagement {
    public static void main(String[] args) {
        // Create course lists for departments
        Course<ExamCourse> csCourses = new Course<>("Computer Science");
        Course<AssignmentCourse> artsCourses = new Course<>("Arts & Humanities");
        Course<ResearchCourse> scienceCourses = new Course<>("Science and Research");

        // Add courses to departments
        csCourses.addCourse(new ExamCourse("Data Structures", 4));
        csCourses.addCourse(new ExamCourse("Operating Systems", 3));

        artsCourses.addCourse(new AssignmentCourse("Creative Writing", 2));
        artsCourses.addCourse(new AssignmentCourse("Philosophy", 3));

        scienceCourses.addCourse(new ResearchCourse("Quantum Mechanics", 5));
        scienceCourses.addCourse(new ResearchCourse("Genetic Research", 4));

        // Display all courses department-wise
        System.out.println("=== " + csCourses.getDepartmentName() + " Courses ===");
        Course.displayCourses(csCourses.getCourses());

        System.out.println("\n=== " + artsCourses.getDepartmentName() + " Courses ===");
        Course.displayCourses(artsCourses.getCourses());

        System.out.println("\n=== " + scienceCourses.getDepartmentName() + " Courses ===");
        Course.displayCourses(scienceCourses.getCourses());
    }
}
