import java.util.Scanner;

// Node class for each ticket
class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

// Circular linked list for ticket reservation system
class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add a new ticket at the end
    public void addTicket(int id, String customer, String movie, String seat, String time) {
        Ticket newTicket = new Ticket(id, customer, movie, seat, time);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully!");
    }

    // Remove a ticket by Ticket ID
    public void removeTicket(int id) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket curr = head;
        Ticket prev = tail;
        boolean found = false;

        do {
            if (curr.ticketId == id) {
                found = true;
                break;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        if (!found) {
            System.out.println("Ticket with ID " + id + " not found.");
            return;
        }

        if (curr == head && curr == tail) {
            head = tail = null;
        } else if (curr == head) {
            head = head.next;
            tail.next = head;
        } else if (curr == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = curr.next;
        }

        System.out.println("Ticket with ID " + id + " removed successfully.");
    }

    // Display all tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("\n--- Booked Tickets ---");
        Ticket temp = head;
        do {
            System.out.println("Ticket ID: " + temp.ticketId +
                               ", Customer: " + temp.customerName +
                               ", Movie: " + temp.movieName +
                               ", Seat: " + temp.seatNumber +
                               ", Time: " + temp.bookingTime);
            temp = temp.next;
        } while (temp != head);
    }

    // Search ticket by Customer Name
    public void searchByCustomer(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.customerName.equalsIgnoreCase(name)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Movie: " + temp.movieName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for customer " + name);
    }

    // Search ticket by Movie Name
    public void searchByMovie(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }

        boolean found = false;
        Ticket temp = head;
        do {
            if (temp.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Ticket ID: " + temp.ticketId + ", Customer: " + temp.customerName + ", Seat: " + temp.seatNumber);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tickets found for movie " + movie);
    }

    // Count total tickets
    public void countTickets() {
        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }

        int count = 0;
        Ticket temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Total booked tickets: " + count);
    }
}
public class ReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        while (true) {
            System.out.println("\n--- Ticket Reservation Menu ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search by Customer Name");
            System.out.println("5. Search by Movie Name");
            System.out.println("6. Count Total Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customer = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String time = sc.nextLine();
                    system.addTicket(id, customer, movie, seat, time);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    int removeId = sc.nextInt();
                    system.removeTicket(removeId);
                    break;
                case 3:
                    system.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name: ");
                    String searchCustomer = sc.nextLine();
                    system.searchByCustomer(searchCustomer);
                    break;
                case 5:
                    System.out.print("Enter Movie Name: ");
                    String searchMovie = sc.nextLine();
                    system.searchByMovie(searchMovie);
                    break;
                case 6:
                    system.countTickets();
                    break;
                case 7:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
