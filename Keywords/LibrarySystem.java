public class LibrarySystem {

    // Book class definition
    static class Book {

        // Static variable: shared among all Book objects
        static String libraryName = "Central City Library";

        // Final variable: ISBN should not be changed once assigned
        private final String isbn;

        // Instance variables
        private String title;
        private String author;

        // Constructor using 'this' to resolve ambiguity
        public Book(String title, String author, String isbn) {
            this.title = title;       // 'this' clarifies that we're referring to the instance variable
            this.author = author;
            this.isbn = isbn;
        }

        // Static method to display the library name
        public static void displayLibraryName() {
            System.out.println("Library Name: " + libraryName);
        }

        // Method to display book details
        public void displayBookDetails() {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
            System.out.println("-----------------------------");
        }
    }

    // Main method to demonstrate the program
    public static void main(String[] args) {

        // Creating Book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");

        // instanceof check before accessing book details
        if (book1 instanceof Book) {
            book1.displayBookDetails();
        }

        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }

        // Calling static method to display shared library name
        Book.displayLibraryName();
    }
}
