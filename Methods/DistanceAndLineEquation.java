public class DistanceAndLineEquation {

    

    public static double calculateEuclideanDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    
    public static double[] getLineEquation(double x1, double y1, double x2, double y2) {
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    
    public static void main(String[] args) {
        
        double x1 = 2, y1 = 3;
        double x2 = 6, y2 = 7;

        System.out.println("Point A: (" + x1 + ", " + y1 + ")");
        System.out.println("Point B: (" + x2 + ", " + y2 + ")");

       
        double distance = calculateEuclideanDistance(x1, y1, x2, y2);
        System.out.printf("Euclidean Distance = %.2f\n", distance);

       
        if (x1 == x2) {
            System.out.println("Line is vertical. Equation: x = " + x1);
        } else {
            double[] result = getLineEquation(x1, y1, x2, y2);
            double m = result[0];
            double b = result[1];
            System.out.printf("Equation of the Line: y = %.2fx + %.2f\n", m, b);
        }
    }
}
