import java.util.*;

public class BinaryGenerator {
    public static void main(String[] args) {
        int N = 5;
        List<String> binaryNumbers = generateBinaryNumbers(N);
        System.out.println("First " + N + " binary numbers: " + binaryNumbers);
    }

    public static List<String> generateBinaryNumbers(int n) {
        List<String> result = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");

        for (int i = 0; i < n; i++) {
            String front = q.remove();
            result.add(front);
            q.add(front + "0");
            q.add(front + "1");
        }

        return result;
    }
}
