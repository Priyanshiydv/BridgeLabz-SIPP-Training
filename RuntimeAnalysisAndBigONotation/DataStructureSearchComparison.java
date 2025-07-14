import java.util.*;

public class DataStructureSearchComparison {

    public static void main(String[] args) {
        int N = 1_000_000;
        int target = -1;

        // Array
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = i;
        }

        long startArr = System.nanoTime();
        for (int val : array) {
            if (val == target) break;
        }
        long endArr = System.nanoTime();
        System.out.printf("Array Search Time: %.3f ms%n", (endArr - startArr) / 1_000_000.0);

        // HashSet
        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(i);
        }

        long startHash = System.nanoTime();
        hashSet.contains(target);
        long endHash = System.nanoTime();
        System.out.printf("HashSet Search Time: %.3f ms%n", (endHash - startHash) / 1_000_000.0);

        // TreeSet
        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            treeSet.add(i);
        }

        long startTree = System.nanoTime();
        treeSet.contains(target);
        long endTree = System.nanoTime();
        System.out.printf("TreeSet Search Time: %.3f ms%n", (endTree - startTree) / 1_000_000.0);
    }
}
