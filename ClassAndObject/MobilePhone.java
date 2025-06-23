// Class to represent a Mobile Phone
class MobilePhone {
    String brand; // Brand of the phone
    String model; // Model name of the phone
    double price; // Price of the phone

    // Constructor to set phone details
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display phone details
    void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: ₹" + price);
    }

    // Main method to run the program
    public static void main(String[] args) {
        MobilePhone m = new MobilePhone("Samsung", "Galaxy S23", 74999);
        m.displayDetails(); // Displaying phone details
    }
}
