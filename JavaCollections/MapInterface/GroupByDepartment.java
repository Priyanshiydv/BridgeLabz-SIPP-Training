import java.util.*;

class Employee {
    String name;
    String department;

    public Employee(String name, String dept) {
        this.name = name;
        this.department = dept;
    }

    @Override
    public String toString() {
        return name;
    }
}

public class GroupByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "HR"),
            new Employee("Bob", "IT"),
            new Employee("Carol", "HR")
        );

        Map<String, List<Employee>> grouped = new HashMap<>();

        for (Employee e : employees) {
            grouped.computeIfAbsent(e.department, k -> new ArrayList<>()).add(e);
        }

        System.out.println("Employees Grouped by Department:");
        for (Map.Entry<String, List<Employee>> entry : grouped.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
