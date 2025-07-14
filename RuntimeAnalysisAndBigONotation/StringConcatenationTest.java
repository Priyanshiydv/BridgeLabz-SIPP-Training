public class StringConcatenationTest {
    public static void main(String[] args) {
        int N = 10000; // Use smaller values first like 1000 or 10000 for fast testing

        //  Using String (Very Slow for large N)
        System.out.println("Testing String concatenation...");
        long startString = System.nanoTime();
        String result = "";
        for (int i = 0; i < N; i++) {
            result += "a"; // O(N^2), very inefficient
        }
        long endString = System.nanoTime();
        System.out.printf("String Concatenation Time: %.2f ms%n", (endString - startString) / 1_000_000.0);

        //  Using StringBuilder (Fast)
        System.out.println("Testing StringBuilder concatenation...");
        long startBuilder = System.nanoTime();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            builder.append("a");
        }
        long endBuilder = System.nanoTime();
        System.out.printf("StringBuilder Time: %.2f ms%n", (endBuilder - startBuilder) / 1_000_000.0);

        // Using StringBuffer (Thread-safe, slightly slower)
        System.out.println("Testing StringBuffer concatenation...");
        long startBuffer = System.nanoTime();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < N; i++) {
            buffer.append("a");
        }
        long endBuffer = System.nanoTime();
        System.out.printf("StringBuffer Time: %.2f ms%n", (endBuffer - startBuffer) / 1_000_000.0);
    }
}
