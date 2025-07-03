import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int bookId;
    boolean isAvailable;
    Book next;
    Book prev;

    public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.isAvailable = isAvailable;
        this.next = null;
        this.prev = null;
    }
}

class Library {
    private Book head = null;
    private Book tail = null;

    // Add at beginning
    public void addAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    public void addAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(int pos, String title, String author, String genre, int bookId, boolean isAvailable) {
        if (pos <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, isAvailable);
            return;
        }

        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        Book temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            newBook.next = temp.next;
            newBook.prev = temp;
            temp.next.prev = newBook;
            temp.next = newBook;
        }
    }

    // Remove book by ID
    public void removeByBookId(int bookId) {
        if (head == null) return;

        Book temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    if (tail != null) tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    // Search by title
    public void searchByTitle(String title) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    // Search by author
    public void searchByAuthor(String author) {
        Book temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Book not found.");
    }

    // Update availability
    public void updateAvailability(int bookId, boolean newStatus) {
        Book temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = newStatus;
                System.out.println("Availability updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display forward
    public void displayForward() {
        Book temp = head;
        System.out.println("\nBooks in Forward Order:");
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    public void displayReverse() {
        Book temp = tail;
        System.out.println("\nBooks in Reverse Order:");
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    public void countBooks() {
        int count = 0;
        Book temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        System.out.println("Total books in library: " + count);
    }

    // Utility method
    private void displayBook(Book b) {
        System.out.println("ID: " + b.bookId + ", Title: " + b.title + ", Author: " + b.author +
                ", Genre: " + b.genre + ", Available: " + (b.isAvailable ? "Yes" : "No"));
    }
}
public class LibraryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Books");
            System.out.println("11. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter Genre: ");
                    String genre = sc.nextLine();
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    System.out.print("Is Available (true/false): ");
                    boolean available = sc.nextBoolean();
                    if (choice == 1)
                        lib.addAtBeginning(title, author, genre, id, available);
                    else if (choice == 2)
                        lib.addAtEnd(title, author, genre, id, available);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        lib.addAtPosition(pos, title, author, genre, id, available);
                    }
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    int remId = sc.nextInt();
                    lib.removeByBookId(remId);
                    break;
                case 5:
                    System.out.print("Enter Title to search: ");
                    String searchTitle = sc.nextLine();
                    lib.searchByTitle(searchTitle);
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    String searchAuthor = sc.nextLine();
                    lib.searchByAuthor(searchAuthor);
                    break;
                case 7:
                    System.out.print("Enter Book ID: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new Availability (true/false): ");
                    boolean newStatus = sc.nextBoolean();
                    lib.updateAvailability(updateId, newStatus);
                    break;
                case 8:
                    lib.displayForward();
                    break;
                case 9:
                    lib.displayReverse();
                    break;
                case 10:
                    lib.countBooks();
                    break;
                case 11:
                    System.out.println("Exiting Library System...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
