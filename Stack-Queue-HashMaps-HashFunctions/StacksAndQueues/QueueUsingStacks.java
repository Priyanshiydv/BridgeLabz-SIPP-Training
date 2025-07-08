import java.util.Stack;

public class QueueUsingStacks {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    // Enqueue operation
    public void enqueue(int data) {
        stack1.push(data); // Always push to stack1
    }

    // Dequeue operation
    public int dequeue() {
        // If stack2 is empty, move elements from stack1 to stack2
        if (stack2.isEmpty()) {
            if (stack1.isEmpty()) {
                System.out.println("Queue is empty!");
                return -1;
            }
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop(); // Return top of stack2
    }

    public static void main(String[] args) {
        QueueUsingStacks q = new QueueUsingStacks();
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        System.out.println(q.dequeue()); // 10
        System.out.println(q.dequeue()); // 20
    }
}
