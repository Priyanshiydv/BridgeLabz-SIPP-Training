import java.util.*;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>(Arrays.asList("A", "B", "C", "D", "E"));
        int n = 2;

        Iterator<String> slow = list.iterator();
        Iterator<String> fast = list.iterator();

        // Move fast pointer n steps ahead
        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                System.out.println("List is shorter than " + n);
                return;
            }
        }

        // Move both until fast reaches end
        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        // slow now points to the nth element from the end
        if (slow.hasNext()) {
            System.out.println(n + "th element from the end is: " + slow.next());
        }
    }
}
