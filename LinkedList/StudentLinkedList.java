// Node class representing each student
class StudentNode {
    int rollNumber;
    String name;
    int age;
    char grade;
    StudentNode next;

    // Constructor
    public StudentNode(int rollNumber, String name, int age, char grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

// Singly Linked List class for managing student records
public class StudentLinkedList {
    private StudentNode head;

    // Add student at the beginning
    public void addAtBeginning(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        newNode.next = head;
        head = newNode;
    }

    // Add student at the end
    public void addAtEnd(int rollNumber, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);

        if (head == null) {
            head = newNode;
            return;
        }

        StudentNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // Add student at specific position (0-based index)
    public void addAtPosition(int position, int rollNumber, String name, int age, char grade) {
        if (position == 0) {
            addAtBeginning(rollNumber, name, age, grade);
            return;
        }

        StudentNode newNode = new StudentNode(rollNumber, name, age, grade);
        StudentNode temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of bounds.");
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Delete student by roll number
    public void deleteByRollNumber(int rollNumber) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Delete head
        if (head.rollNumber == rollNumber) {
            head = head.next;
            return;
        }

        StudentNode current = head;
        StudentNode prev = null;

        while (current != null && current.rollNumber != rollNumber) {
            prev = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Student with Roll Number " + rollNumber + " not found.");
            return;
        }

        prev.next = current.next;
        current.next = null; // Help GC
    }

    // Search student by roll number
    public void searchByRollNumber(int rollNumber) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Found: " + temp.rollNumber + ", " + temp.name + ", " + temp.age + ", " + temp.grade);
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Update grade by roll number
    public void updateGrade(int rollNumber, char newGrade) {
        StudentNode temp = head;

        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Grade updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Student with Roll Number " + rollNumber + " not found.");
    }

    // Display all students
    public void displayAll() {
        if (head == null) {
            System.out.println("No student records to display.");
            return;
        }

        StudentNode temp = head;
        System.out.println("Student Records:");
        while (temp != null) {
            System.out.println(temp.rollNumber + " | " + temp.name + " | Age: " + temp.age + " | Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    // Main method to test
    public static void main(String[] args) {
        StudentLinkedList studentList = new StudentLinkedList();

        studentList.addAtEnd(101, "Alice", 20, 'A');
        studentList.addAtBeginning(102, "Bob", 21, 'B');
        studentList.addAtPosition(1, 103, "Charlie", 19, 'C');

        studentList.displayAll();
        studentList.searchByRollNumber(102);
        studentList.updateGrade(103, 'A');
        studentList.deleteByRollNumber(101);
        studentList.displayAll();
    }
}
