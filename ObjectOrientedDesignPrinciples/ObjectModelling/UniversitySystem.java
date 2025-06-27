import java.util.*;

// Faculty can exist independently (aggregation)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println("Faculty: " + name);
    }

    public String getName() {
        return name;
    }
}

// Department is part of University (composition)
class Department {
    private String name;

    public Department(String name) {
        this.name = name;
    }

    public void showDetails() {
        System.out.println("Department: " + name);
    }
}

// University has departments (composition) and faculties (aggregation)
class University {
    private String universityName;
    private List<Department> departments = new ArrayList<>();
    private List<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.universityName = name;
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty); // aggregation: faculty can exist outside
    }

    public void showStructure() {
        System.out.println("University: " + universityName);
        System.out.println("Departments:");
        for (Department d : departments) {
            d.showDetails();
        }
        System.out.println("Faculties:");
        for (Faculty f : faculties) {
            f.displayInfo();
        }
    }

    public void deleteUniversity() {
        departments.clear(); // Composition: all departments destroyed
        System.out.println("University " + universityName + " and its departments have been deleted.");
    }
}

// Main class
public class UniversitySystem {
    public static void main(String[] args) {
        University uni = new University("Oxford");

        // Add departments
        uni.addDepartment("Computer Science");
        uni.addDepartment("Physics");

        // Faculties can exist independently
        Faculty drSmith = new Faculty("Dr. Smith");
        Faculty drJones = new Faculty("Dr. Jones");

        uni.addFaculty(drSmith);
        uni.addFaculty(drJones);

        // Show university structure
        uni.showStructure();

        // Simulate deletion
        uni.deleteUniversity();

        // Faculties still exist
        System.out.println("\nIndependent Faculties:");
        drSmith.displayInfo();
        drJones.displayInfo();
    }
}
