import java.util.*;

class CustomHashMap {
    static class Node {
        int key, value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int SIZE = 10;
    private Node[] buckets = new Node[SIZE];

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) {
                head.value = value; // Update existing
                return;
            }
            head = head.next;
        }

        // Insert at head (chaining)
        Node newNode = new Node(key, value);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public Integer get(int key) {
        int index = getIndex(key);
        Node head = buckets[index];

        while (head != null) {
            if (head.key == key) return head.value;
            head = head.next;
        }
        return null;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node head = buckets[index], prev = null;

        while (head != null) {
            if (head.key == key) {
                if (prev != null) prev.next = head.next;
                else buckets[index] = head.next;
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public static void main(String[] args) {
        CustomHashMap map = new CustomHashMap();
        map.put(1, 10);
        map.put(11, 20); // Collision handled
        System.out.println(map.get(1));   // 10
        System.out.println(map.get(11));  // 20
        map.remove(1);
        System.out.println(map.get(1));   // null
    }
}
