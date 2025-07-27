import java.util.*;

class StackUsingQueues {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    // Push element
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        // Swap queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Pop top element
    public int pop() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return q1.remove();
    }

    // Peek top element
    public int top() {
        if (q1.isEmpty()) throw new NoSuchElementException("Stack is empty");
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackQueueDemo {
    public static void main(String[] args) {
        StackUsingQueues stack = new StackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top: " + stack.top()); // 3
        System.out.println("Popped: " + stack.pop()); // 3
    }
}
