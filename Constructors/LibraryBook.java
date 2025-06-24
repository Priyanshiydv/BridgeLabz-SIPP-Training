// Library Book class with availability
class LibraryBook {
    String title;
    String author;
    double price;
    boolean isAvailable;

    // Constructor
    LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = true; // Initially available
    }

    // Method to borrow the book
    void borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Book already borrowed: " + title);
        }
    }

    void displayInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: ₹" + price + ", Available: " + isAvailable);
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Effective Java", "Joshua Bloch", 799.99);
        book.displayInfo();
        book.borrowBook();
        book.displayInfo();
        book.borrowBook(); // Attempt to borrow again
    }
}
