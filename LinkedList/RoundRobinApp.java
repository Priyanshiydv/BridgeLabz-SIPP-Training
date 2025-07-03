import java.util.*;

class Process {
    int processId;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime = 0;
    int turnAroundTime = 0;
    Process next;

    public Process(int processId, int burstTime, int priority) {
        this.processId = processId;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;

    // Add process at the end
    public void addProcess(int id, int burst, int priority) {
        Process newProcess = new Process(id, burst, priority);
        if (head == null) {
            head = newProcess;
            head.next = head;
        } else {
            Process temp = head;
            while (temp.next != head) temp = temp.next;
            temp.next = newProcess;
            newProcess.next = head;
        }
    }

    // Remove process by ID
    private void removeProcess(int id) {
        if (head == null) return;

        Process curr = head, prev = null;

        // Special case: only one node
        if (head.processId == id && head.next == head) {
            head = null;
            return;
        }

        // Find the process to delete
        do {
            if (curr.processId == id) {
                if (curr == head) {
                    // Move head and fix tail link
                    Process tail = head;
                    while (tail.next != head) tail = tail.next;
                    head = head.next;
                    tail.next = head;
                } else {
                    prev.next = curr.next;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);
    }

    // Simulate Round Robin Scheduling
    public void simulate(int quantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        Map<Integer, Integer> waitingTimes = new HashMap<>();
        Map<Integer, Integer> turnaroundTimes = new HashMap<>();
        int time = 0;
        Process curr = head;

        System.out.println("\n--- Round Robin Scheduling Start ---");

        while (head != null) {
            if (curr.remainingTime > 0) {
                System.out.println("Time " + time + ": Executing Process " + curr.processId);
                int execTime = Math.min(quantum, curr.remainingTime);
                time += execTime;
                curr.remainingTime -= execTime;

                // If finished, calculate turnaround and waiting time
                if (curr.remainingTime == 0) {
                    curr.turnAroundTime = time;
                    curr.waitingTime = curr.turnAroundTime - curr.burstTime;
                    turnaroundTimes.put(curr.processId, curr.turnAroundTime);
                    waitingTimes.put(curr.processId, curr.waitingTime);
                    System.out.println("Process " + curr.processId + " completed.");

                    Process temp = curr.next;
                    removeProcess(curr.processId);
                    curr = temp;
                } else {
                    curr = curr.next;
                }

                displayProcesses();
            } else {
                curr = curr.next;
            }

            if (head == null) break;
        }

        // Calculate averages
        double avgWaiting = 0, avgTurnaround = 0;
        for (int id : waitingTimes.keySet()) {
            avgWaiting += waitingTimes.get(id);
            avgTurnaround += turnaroundTimes.get(id);
        }

        int n = waitingTimes.size();
        System.out.println("\n--- Scheduling Complete ---");
        System.out.println("Average Waiting Time: " + (avgWaiting / n));
        System.out.println("Average Turnaround Time: " + (avgTurnaround / n));
    }

    // Display current process list
    public void displayProcesses() {
        if (head == null) {
            System.out.println("No active processes.");
            return;
        }

        System.out.println("Current Process Queue:");
        Process temp = head;
        do {
            System.out.println("Process ID: " + temp.processId + ", Remaining Time: " + temp.remainingTime + ", Priority: " + temp.priority);
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }
}
public class RoundRobinApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        while (true) {
            System.out.println("\n--- Round Robin Scheduler Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Simulate Scheduling");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    int bt = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    int p = sc.nextInt();
                    scheduler.addProcess(id, bt, p);
                    break;
                case 2:
                    scheduler.displayProcesses();
                    break;
                case 3:
                    System.out.print("Enter Time Quantum: ");
                    int quantum = sc.nextInt();
                    scheduler.simulate(quantum);
                    break;
                case 4:
                    System.out.println("Exiting Scheduler...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
