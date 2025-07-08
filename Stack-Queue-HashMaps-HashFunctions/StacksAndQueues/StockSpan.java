import java.util.Stack;

public class StockSpan {
    static void calculateSpan(int[] prices, int n) {
        int[] span = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        stack.push(0); // First day span is always 1
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            // Pop elements smaller than current
            while (!stack.isEmpty() && prices[i] >= prices[stack.peek()]) {
                stack.pop();
            }
            // If stack is empty, span = i + 1
            span[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        for (int s : span) {
            System.out.print(s + " ");
        }
    }

    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        calculateSpan(prices, prices.length);
        // Output: 1 1 1 2 1 4 6
    }
}
