import java.util.Scanner;

// Node class representing a state of text
class TextState {
    String content;           // The text content
    TextState prev, next;     // Pointers for previous and next states (doubly linked)

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

// Core editor logic using a doubly linked list to track text states
class TextEditor {
    private TextState head = null;     // First node (oldest state)
    private TextState current = null;  // Currently active state
    private int size = 0;              // Total number of states in history
    private final int LIMIT = 10;      // Maximum allowed states in history

    // Add new state (typing or command execution)
    public void addState(String content) {
        TextState newState = new TextState(content);

        // If we are not at the end of the list, discard forward (redo) states
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
        }

        // Add new state at the end
        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }

        size++;

        // If history exceeds limit, remove the oldest state
        if (size > LIMIT) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo: Move to previous state
    public void undo() {
        if (current != null && current.prev != null) {
            current = current.prev;
            System.out.println("Undo successful.");
        } else {
            System.out.println("No more undo operations possible.");
        }
    }

    // Redo: Move to next state
    public void redo() {
        if (current != null && current.next != null) {
            current = current.next;
            System.out.println("Redo successful.");
        } else {
            System.out.println("No more redo operations possible.");
        }
    }

    // Display the current text state
    public void displayCurrent() {
        if (current != null) {
            System.out.println("Current Text: \"" + current.content + "\"");
        } else {
            System.out.println("No content to display.");
        }
    }

    // Show entire history (from head to current)
    public void showHistory() {
        System.out.println("\n--- History (Oldest to Newest) ---");
        TextState temp = head;
        while (temp != null) {
            if (temp == current)
                System.out.println("-> [Current] " + temp.content);
            else
                System.out.println("   " + temp.content);
            temp = temp.next;
        }
    }
}
public class TextEditorApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditor editor = new TextEditor();

        while (true) {
            // Menu
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Show History");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine(); // consume newline after number input

            switch (ch) {
                case 1:
                    // Add new text state
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    break;
                case 2:
                    editor.undo();
                    break;
                case 3:
                    editor.redo();
                    break;
                case 4:
                    editor.displayCurrent();
                    break;
                case 5:
                    editor.showHistory();
                    break;
                case 6:
                    System.out.println("Exiting Text Editor...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
