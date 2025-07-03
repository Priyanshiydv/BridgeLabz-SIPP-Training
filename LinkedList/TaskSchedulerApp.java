import java.util.Scanner;

class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add at beginning
    public void addTaskAtBeginning(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addTaskAtEnd(int taskId, String taskName, int priority, String dueDate) {
        Task newTask = new Task(taskId, taskName, priority, dueDate);
        if (head == null) {
            head = tail = newTask;
            tail.next = head;
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position (1-based index)
    public void addTaskAtPosition(int position, int taskId, String taskName, int priority, String dueDate) {
        if (position <= 1) {
            addTaskAtBeginning(taskId, taskName, priority, dueDate);
            return;
        }

        Task newTask = new Task(taskId, taskName, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove task by Task ID
    public void removeTaskById(int taskId) {
        if (head == null) return;

        Task temp = head;
        Task prev = tail;
        boolean found = false;

        do {
            if (temp.taskId == taskId) {
                found = true;
                if (temp == head && temp == tail) {
                    head = tail = null;
                } else {
                    prev.next = temp.next;
                    if (temp == head) head = temp.next;
                    if (temp == tail) tail = prev;
                }
                tail.next = head;
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("Task ID not found.");
        }
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            current = head;
        }

        if (current != null) {
            System.out.println("Current Task -> ID: " + current.taskId + ", Name: " + current.taskName +
                    ", Priority: " + current.priority + ", Due: " + current.dueDate);
        } else {
            System.out.println("No tasks available.");
        }
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            viewCurrentTask();
        } else {
            System.out.println("No tasks to move.");
        }
    }

    // Display all tasks
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks in the list.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            System.out.println("ID: " + temp.taskId + ", Name: " + temp.taskName +
                    ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search tasks by Priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println("Found -> ID: " + temp.taskId + ", Name: " + temp.taskName +
                        ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority " + priority);
        }
    }
}

public class TaskSchedulerApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler Menu ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Specific Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task");
            System.out.println("6. Move to Next Task");
            System.out.println("7. Display All Tasks");
            System.out.println("8. Search by Priority");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();

                    if (choice == 1) {
                        scheduler.addTaskAtBeginning(id, name, priority, date);
                    } else if (choice == 2) {
                        scheduler.addTaskAtEnd(id, name, priority, date);
                    } else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addTaskAtPosition(pos, id, name, priority, date);
                    }
                    break;
                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    int removeId = sc.nextInt();
                    scheduler.removeTaskById(removeId);
                    break;
                case 5:
                    scheduler.viewCurrentTask();
                    break;
                case 6:
                    scheduler.moveToNextTask();
                    break;
                case 7:
                    scheduler.displayAllTasks();
                    break;
                case 8:
                    System.out.print("Enter Priority to search: ");
                    int searchPriority = sc.nextInt();
                    scheduler.searchByPriority(searchPriority);
                    break;
                case 9:
                    System.out.println("Exiting Task Scheduler...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
