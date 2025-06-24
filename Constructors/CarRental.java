// CarRental class to handle car bookings
class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double costPerDay = 1500; // Assuming ₹1500 per day for rental

    // Default constructor
    CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
    }

    // Parameterized constructor
    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    // Method to calculate total cost
    double calculateTotalCost() {
        return rentalDays * costPerDay;
    }

    void displayRentalDetails() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays);
        System.out.println("Total Cost: ₹" + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        CarRental rental2 = new CarRental("Priya Sharma", "Honda City", 4);

        rental1.displayRentalDetails();
        rental2.displayRentalDetails();
    }
}
