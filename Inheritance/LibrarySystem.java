// Superclass: Book
class Book {
    String title;
    int publicationYear;

    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass: Author extends Book
class Author extends Book {
    String authorName;
    String bio;

    Author(String title, int publicationYear, String authorName, String bio) {
        super(title, publicationYear);  // Call superclass constructor
        this.authorName = authorName;
        this.bio = bio;
    }

    // Override displayInfo to include author details
    void displayInfo() {
        super.displayInfo(); // Display book details
        System.out.println("Author Name: " + authorName);
        System.out.println("Author Bio: " + bio);
    }
}

// Main class to test
public class LibrarySystem {
    public static void main(String[] args) {
        Author author = new Author("Java for Beginners", 2021, "Priyanshi Yadav", "Java educator and writer.");
        author.displayInfo();
    }
}
