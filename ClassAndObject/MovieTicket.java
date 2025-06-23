// Class to represent a Movie Ticket
class MovieTicket {
    String movieName;  // Name of the movie
    String seatNumber; // Seat number
    double price;      // Price of the ticket

    // Constructor to initialize with default values
    MovieTicket() {
        this.movieName = "";
        this.seatNumber = "";
        this.price = 0.0;
    }

    // Method to book the ticket (assign movie, seat, price)
    void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked successfully!");
    }

    // Method to display the ticket details
    void displayTicket() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: ₹" + price);
    }

    // Main method to run the program
    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket();
        ticket.bookTicket("Avengers: Endgame", "A10", 300);
        ticket.displayTicket();
    }
}
