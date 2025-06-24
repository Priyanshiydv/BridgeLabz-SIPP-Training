public class EmployeeRecords {

    // Inner class Employee
    static class Employee {
        public int employeeID;         // Public - accessible everywhere
        protected String department;   // Protected - accessible in package & subclass
        private double salary;         // Private - accessible only within Employee

        // Constructor to initialize Employee
        Employee(int employeeID, String department, double salary) {
            this.employeeID = employeeID;
            this.department = department;
            this.salary = salary;
        }

        // Public method to get salary
        public double getSalary() {
            return salary;
        }

        // Public method to modify salary
        public void setSalary(double salary) {
            if (salary >= 0) {
                this.salary = salary;
            } else {
                System.out.println("Invalid salary.");
            }
        }
    }

    // Inner subclass Manager extending Employee
    static class Manager extends Employee {
        String designation;

        // Constructor for Manager
        Manager(int employeeID, String department, double salary, String designation) {
            super(employeeID, department, salary);
            this.designation = designation;
        }

        // Method to display manager information
        void displayManagerInfo() {
            System.out.println("Employee ID: " + employeeID);   // public access
            System.out.println("Department: " + department);    // protected access
            System.out.println("Designation: " + designation);
            System.out.println("Salary: ₹" + getSalary());      // private accessed using public getter
            System.out.println("------------------------------");
        }
    }

    // Main method to test
    public static void main(String[] args) {
        Manager manager = new Manager(101, "IT", 80000, "Project Manager");

        // Display manager details before salary update
        manager.displayManagerInfo();

        // Update salary using public setter
        manager.setSalary(90000);

        System.out.println("After Salary Update:");
        manager.displayManagerInfo();
    }
}
