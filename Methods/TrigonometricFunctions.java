import java.util.Scanner;

public class TrigonometricFunctions {

    public static double[] calculateTrigonometricFunctions(double angleDegrees) {
        double angleRadians = Math.toRadians(angleDegrees);
        double[] results = new double[3];
        results[0] = Math.sin(angleRadians);
        results[1] = Math.cos(angleRadians);
        results[2] = Math.tan(angleRadians);
        return results;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();

        double[] trigValues = calculateTrigonometricFunctions(angle);
        System.out.printf("Sine: %.4f\nCosine: %.4f\nTangent: %.4f\n", trigValues[0], trigValues[1], trigValues[2]);
    }
}
