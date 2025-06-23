// Class to represent a Circle
class Circle {
    double radius; // Radius of the circle

    // Constructor to set the radius
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area of the circle
    double getArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference of the circle
    double getCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display radius, area, and circumference
    void display() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
        System.out.println("Circumference: " + getCircumference());
    }

    // Main method to run the program
    public static void main(String[] args) {
        Circle c = new Circle(5); // Create Circle with radius 5
        c.display();              // Display the details
    }
}
