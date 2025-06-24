// Vehicle class to demonstrate instance vs class variables/methods
class Vehicle {
    // Instance variables (unique for each vehicle)
    String ownerName;
    String vehicleType;

    // Class variable (shared among all Vehicle objects)
    static double registrationFee = 5000; // Default registration fee

    // Constructor to initialize vehicle details
    Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
        System.out.println("----------------------------");
    }

    // Class (static) method to update the registration fee
    static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Amit Sharma", "Car");
        Vehicle v2 = new Vehicle("Priya Singh", "Motorbike");

        // Display details before updating registration fee
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update registration fee (affects all vehicles)
        Vehicle.updateRegistrationFee(6000);

        // Display details after updating registration fee
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
