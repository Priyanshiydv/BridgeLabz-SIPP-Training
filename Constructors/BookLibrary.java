// BookLibrary.java - Combined code for Book Library System
public class BookLibrary {

    // Inner Book class
    static class Book {
        public String ISBN;        // Public - accessible everywhere
        protected String title;    // Protected - accessible within package and subclass
        private String author;     // Private - accessible only within this class

        // Constructor
        Book(String ISBN, String title, String author) {
            this.ISBN = ISBN;
            this.title = title;
            this.author = author;
        }

        // Public method to get author (private variable)
        public String getAuthor() {
            return author;
        }

        // Public method to set author (private variable)
        public void setAuthor(String author) {
            this.author = author;
        }
    }

    // Inner subclass EBook extending Book
    static class EBook extends Book {
        double fileSizeMB;

        // Constructor for EBook
        EBook(String ISBN, String title, String author, double fileSizeMB) {
            super(ISBN, title, author);
            this.fileSizeMB = fileSizeMB;
        }

        // Method to display EBook details
        void displayEBookInfo() {
            System.out.println("ISBN: " + ISBN);           // public access
            System.out.println("Title: " + title);         // protected access
            System.out.println("Author: " + getAuthor());  // private accessed through getter
            System.out.println("File Size: " + fileSizeMB + " MB");
        }
    }

    //  Main method to test
    public static void main(String[] args) {
        EBook ebook = new EBook("978-1234567890", "Java for Beginners", "James Gosling", 2.8);
        ebook.displayEBookInfo();

        // Modify the private author using public setter
        ebook.setAuthor("Updated Author");
        System.out.println("\nAfter Updating Author:");
        ebook.displayEBookInfo();
    }
}
