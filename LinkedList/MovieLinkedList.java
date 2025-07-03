// Node representing a Movie
class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode next;
    MovieNode prev;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

// Doubly Linked List class for managing movies
public class MovieLinkedList {
    private MovieNode head;
    private MovieNode tail;

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add movie at the end
    public void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add movie at a specific position (0-based index)
    public void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int count = 0;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
            return;
        }

        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        if (head == null) {
            System.out.println("Movie list is empty.");
            return;
        }

        MovieNode current = head;

        while (current != null && !current.title.equalsIgnoreCase(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found.");
            return;
        }

        if (current == head) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
        } else if (current == tail) {
            tail = tail.prev;
            if (tail != null) tail.next = null;
            else head = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        current.next = current.prev = null; // help GC
        System.out.println("Movie removed successfully.");
    }

    // Search movies by Director
    public void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No movies found by director: " + director);
    }

    // Search movies by Rating (exact match)
    public void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.rating == rating) {
                printMovie(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Update movie rating by title
    public void updateRating(String title, double newRating) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated successfully.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Movie not found.");
    }

    // Display movies forward
    public void displayForward() {
        if (head == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies in forward order:");
        MovieNode temp = head;
        while (temp != null) {
            printMovie(temp);
            temp = temp.next;
        }
    }

    // Display movies in reverse
    public void displayReverse() {
        if (tail == null) {
            System.out.println("No movies to display.");
            return;
        }

        System.out.println("Movies in reverse order:");
        MovieNode temp = tail;
        while (temp != null) {
            printMovie(temp);
            temp = temp.prev;
        }
    }

    // Helper method to print a movie
    private void printMovie(MovieNode node) {
        System.out.println("Title: " + node.title +
                ", Director: " + node.director +
                ", Year: " + node.year +
                ", Rating: " + node.rating);
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        MovieLinkedList movieList = new MovieLinkedList();

        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtBeginning("The Godfather", "Francis Ford Coppola", 1972, 9.2);
        movieList.addAtPosition(1, "Interstellar", "Christopher Nolan", 2014, 8.6);

        movieList.displayForward();
        movieList.displayReverse();

        movieList.searchByDirector("Christopher Nolan");
        movieList.searchByRating(9.2);

        movieList.updateRating("Interstellar", 9.0);
        movieList.removeByTitle("Inception");

        movieList.displayForward();
    }
}
