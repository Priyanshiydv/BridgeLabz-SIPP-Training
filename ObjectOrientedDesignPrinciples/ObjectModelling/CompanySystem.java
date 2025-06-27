import java.util.*;

// Employee class represents individual employees
class Employee {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    // Method to display employee information
    public void displayInfo() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

// Department class contains multiple employees
class Department {
    private String deptName;
    private List<Employee> employees;

    public Department(String name) {
        this.deptName = name;
        this.employees = new ArrayList<>();
    }

    // ✅ Getter method to access deptName (fix for private access error)
    public String getDeptName() {
        return deptName;
    }

    // Add an employee to this department
    public void addEmployee(String empName, String position) {
        Employee emp = new Employee(empName, position);
        employees.add(emp);
    }

    // Display all employees in the department
    public void displayDepartment() {
        System.out.println("Department: " + deptName);
        for (Employee e : employees) {
            e.displayInfo();
        }
    }
}

// Company class contains multiple departments (Composition)
class Company {
    private String companyName;
    private List<Department> departments;

    public Company(String name) {
        this.companyName = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the company
    public void addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
    }

    // Get a specific department by name
    public Department getDepartment(String deptName) {
        for (Department dept : departments) {
            if (deptName.equals(dept.getDeptName())) {
                return dept;
            }
        }
        return null; // Not found
    }

    // Display company structure
    public void showCompanyStructure() {
        System.out.println("Company: " + companyName);
        for (Department d : departments) {
            d.displayDepartment();
        }
    }

    // Delete the company and all its departments and employees
    public void deleteCompany() {
        departments.clear(); // Composition: destroying all departments
        System.out.println("Company " + companyName + " and its departments have been deleted.");
    }
}

// Main class to demonstrate Composition
public class CompanySystem {
    public static void main(String[] args) {
        Company techCorp = new Company("TechCorp");

        // Add departments
        techCorp.addDepartment("IT");
        techCorp.addDepartment("HR");

        // Add employees to IT department
        Department it = techCorp.getDepartment("IT");
        if (it != null) {
            it.addEmployee("Ravi", "Software Engineer");
            it.addEmployee("Priya", "System Analyst");
        }

        // Add employees to HR department
        Department hr = techCorp.getDepartment("HR");
        if (hr != null) {
            hr.addEmployee("Anjali", "HR Manager");
        }

        // Display full company structure
        techCorp.showCompanyStructure();

        // Delete the company (and all its departments & employees)
        techCorp.deleteCompany();
    }
}
