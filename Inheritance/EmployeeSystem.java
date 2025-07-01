// Superclass
class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    void displayDetails() {
        System.out.println("Name: " + name + ", ID: " + id + ", Salary: ₹" + salary);
    }
}

// Subclass: Manager
class Manager extends Employee {
    int teamSize;

    Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Team Size: " + teamSize);
    }
}

// Subclass: Developer
class Developer extends Employee {
    String programmingLanguage;

    Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}

// Subclass: Intern
class Intern extends Employee {
    int durationMonths;

    Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Internship Duration: " + durationMonths + " months");
    }
}

public class EmployeeSystem {
    public static void main(String[] args) {
        Employee e1 = new Manager("Alice", 101, 90000, 5);
        Employee e2 = new Developer("Bob", 102, 70000, "Java");
        Employee e3 = new Intern("Charlie", 103, 15000, 6);

        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
