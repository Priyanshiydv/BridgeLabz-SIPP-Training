// Superclass
class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayBasicInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Subclass 1
class Teacher extends Person {
    String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Teacher");
        System.out.println("Subject: " + subject);
    }
}

// Subclass 2
class Student extends Person {
    int grade;

    Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Student");
        System.out.println("Grade: " + grade);
    }
}

// Subclass 3
class Staff extends Person {
    String department;

    Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }

    void displayRole() {
        displayBasicInfo();
        System.out.println("Role: Staff");
        System.out.println("Department: " + department);
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher t = new Teacher("Priyanshi", 30, "Mathematics");
        Student s = new Student("Aryan", 16, 10);
        Staff st = new Staff("Meena", 40, "Administration");

        t.displayRole();
        System.out.println("---------------------------");
        s.displayRole();
        System.out.println("---------------------------");
        st.displayRole();
    }
}
