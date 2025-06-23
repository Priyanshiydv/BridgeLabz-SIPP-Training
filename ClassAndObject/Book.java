// Class to represent a Book
class Book {
    String title;   // Title of the book
    String author;  // Author of the book
    double price;   // Price of the book

    // Constructor to set the book details
    Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    void displayDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: ₹" + price);
    }

    // Main method to run the program
    public static void main(String[] args) {
        Book b = new Book("Wings of Fire", "A.P.J Abdul Kalam", 350);
        b.displayDetails();
    }
}
