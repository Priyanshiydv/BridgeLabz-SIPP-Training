import java.util.*;

class CircularBuffer {
    int[] buffer;
    int head = 0, count = 0;
    int size;

    public CircularBuffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Insert (overwrites oldest if full)
    public void insert(int value) {
        buffer[(head + count) % size] = value;
        if (count < size) {
            count++;
        } else {
            head = (head + 1) % size;
        }
    }

    // Display buffer contents
    public void display() {
        System.out.print("Buffer: [");
        for (int i = 0; i < count; i++) {
            int index = (head + i) % size;
            System.out.print(buffer[index]);
            if (i < count - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

public class CircularBufferDemo {
    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.display(); // [1, 2, 3]
        cb.insert(4);
        cb.display(); // [2, 3, 4]
    }
}
