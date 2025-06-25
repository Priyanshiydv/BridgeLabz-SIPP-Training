public class VehicleRegistration {

    // Vehicle class representing each registered vehicle
    static class Vehicle {

        // Static variable common to all vehicles
        static double registrationFee = 5000.00;

        // Final variable for unique registration number
        private final String registrationNumber;

        // Instance variables
        private String ownerName;
        private String vehicleType;

        // Constructor using 'this' keyword
        public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
            this.registrationNumber = registrationNumber;
            this.ownerName = ownerName;
            this.vehicleType = vehicleType;
        }

        // Static method to update fee for all
        public static void updateRegistrationFee(double newFee) {
            registrationFee = newFee;
        }

        // Display vehicle details
        public void displayVehicleDetails() {
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Fee: ₹" + registrationFee);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Amit", "Car");
        Vehicle v2 = new Vehicle("MH14XY7890", "Sneha", "Bike");

        if (v1 instanceof Vehicle) v1.displayVehicleDetails();
        if (v2 instanceof Vehicle) v2.displayVehicleDetails();

        Vehicle.updateRegistrationFee(5500);
    }
}
