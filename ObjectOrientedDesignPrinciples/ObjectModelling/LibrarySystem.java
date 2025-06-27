import java.util.ArrayList;

// Book class - can exist independently of a Library
class Book {
    String title;
    String author;

    // Constructor to initialize Book attributes
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Method to display book details
    public void displayBook() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

// Library class - aggregates multiple Book objects
class Library {
    String libraryName;
    ArrayList<Book> books;  // Aggregation: Library has a list of books

    // Constructor to initialize the library and its book list
    public Library(String name) {
        this.libraryName = name;
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
    }

    // Method to display all books in the library
    public void showBooks() {
        System.out.println("Books in " + libraryName + " Library:");
        for (Book b : books) {
            b.displayBook();
        }
    }
}

// Main class to test the aggregation relationship
public class LibrarySystem {
    public static void main(String[] args) {
        // Create independent Book objects
        Book book1 = new Book("The Alchemist", "Paulo Coelho");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("Clean Code", "Robert C. Martin");

        // Create Library objects
        Library centralLibrary = new Library("Central");
        Library communityLibrary = new Library("Community");

        // Add books to Central Library
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);

        // Add books to Community Library
        communityLibrary.addBook(book2);  // Book shared between libraries
        communityLibrary.addBook(book3);

        // Display books in each library
        centralLibrary.showBooks();
        System.out.println();  // Just a spacer
        communityLibrary.showBooks();
    }
}
