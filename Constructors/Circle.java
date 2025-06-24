// Circle class with constructor chaining
class Circle {
    double radius;

    // Default constructor
    Circle() {
        this(1.0); // Calls parameterized constructor with default value 1.0
    }

    // Parameterized constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area of the circle
    double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle defaultCircle = new Circle();
        Circle customCircle = new Circle(5.0);

        System.out.println("Default Circle Radius: " + defaultCircle.radius + ", Area: " + defaultCircle.getArea());
        System.out.println("Custom Circle Radius: " + customCircle.radius + ", Area: " + customCircle.getArea());
    }
}
