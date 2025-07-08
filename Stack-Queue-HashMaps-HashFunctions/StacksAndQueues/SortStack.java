import java.util.Stack;

public class SortStack {
    // Recursive function to sort stack
    static void sort(Stack<Integer> stack) {
        if (!stack.isEmpty()) {
            int temp = stack.pop();     // Pop top element
            sort(stack);                // Sort remaining stack
            insertInSortedOrder(stack, temp); // Insert current element
        }
    }

    // Insert element in sorted order
    static void insertInSortedOrder(Stack<Integer> stack, int val) {
        if (stack.isEmpty() || stack.peek() <= val) {
            stack.push(val);
        } else {
            int temp = stack.pop();
            insertInSortedOrder(stack, val);
            stack.push(temp); // Push back other elements
        }
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(30);
        s.push(10);
        s.push(20);
        sort(s);
        while (!s.isEmpty()) {
            System.out.print(s.pop() + " "); // 10 20 30
        }
    }
}
