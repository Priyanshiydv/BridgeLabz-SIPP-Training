import java.util.Scanner;

public class TriangularParkRun {

    
    public static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000; // 5 kilometers in meters
        return (int)Math.ceil(totalDistance / perimeter);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the first side of the triangle (in meters): ");
        double side1 = sc.nextDouble();

        System.out.print("Enter the second side of the triangle (in meters): ");
        double side2 = sc.nextDouble();

        System.out.print("Enter the third side of the triangle (in meters): ");
        double side3 = sc.nextDouble();

        
        int rounds = calculateRounds(side1, side2, side3);

        
        System.out.println("The athlete must complete " + rounds + " rounds to complete a 5 km run.");
    }
}
