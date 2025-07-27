import java.util.*;
//Reverse List without BuiltIN Reverse
public class ReverseList {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int left = 0;
        int right = arrayList.size() - 1;

        // Swap elements using two pointers
        while (left < right) {
            int temp = arrayList.get(left);
            arrayList.set(left, arrayList.get(right));
            arrayList.set(right, temp);
            left++;
            right--;
        }

        System.out.println("Reversed ArrayList: " + arrayList);

        // LinkedList version
        List<Integer> linkedList = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5));
        left = 0;
        right = linkedList.size() - 1;

        while (left < right) {
            int temp = linkedList.get(left);
            linkedList.set(left, linkedList.get(right));
            linkedList.set(right, temp);
            left++;
            right--;
        }

        System.out.println("Reversed LinkedList: " + linkedList);
    }
}
