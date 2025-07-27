import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(10, 20, 30));
        Queue<Integer> reversed = reverse(queue);
        System.out.println("Reversed Queue: " + reversed);
    }

    // Recursive reversal
    public static Queue<Integer> reverse(Queue<Integer> q) {
        if (q.isEmpty()) return q;
        int front = q.remove();
        reverse(q);
        q.add(front);
        return q;
    }
}
