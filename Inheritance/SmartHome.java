// Superclass: Device
class Device {
    String deviceId;
    String status;

    Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass: Thermostat extends Device
class Thermostat extends Device {
    double temperatureSetting;

    Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status);  // Call superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Override to show additional thermostat info
    void displayStatus() {
        super.displayStatus(); // Show device ID and status
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to test
public class SmartHome {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("THM001", "Active", 23.5);
        t1.displayStatus();
    }
}
