public class FibonacciComparison {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }

    public static int fibonacciIterative(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 30; // Try 10, 30, 50

        // Recursive
        long startRec = System.nanoTime();
        int rec = fibonacciRecursive(n);
        long endRec = System.nanoTime();
        System.out.printf("Recursive Fibonacci(%d): %d, Time: %.3f ms%n", n, rec, (endRec - startRec) / 1_000_000.0);

        // Iterative
        long startItr = System.nanoTime();
        int itr = fibonacciIterative(n);
        long endItr = System.nanoTime();
        System.out.printf("Iterative Fibonacci(%d): %d, Time: %.3f ms%n", n, itr, (endItr - startItr) / 1_000_000.0);
    }
}
