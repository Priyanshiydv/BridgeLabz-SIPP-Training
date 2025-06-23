public class CollinearChecker {

    
    public static boolean arePointsCollinearBySlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        // Avoid division by zero: use cross multiplication instead
        int slope1 = (y2 - y1) * (x3 - x1);
        int slope2 = (y3 - y1) * (x2 - x1);
        return slope1 == slope2;
    }

    
    public static boolean arePointsCollinearByArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (
                x1 * (y2 - y3) +
                x2 * (y3 - y1) +
                x3 * (y1 - y2)
        );
        return area == 0.0;
    }

    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;

        System.out.println("Using Slope Method: " + (arePointsCollinearBySlope(x1, y1, x2, y2, x3, y3) ? "Collinear" : "Not Collinear"));
        System.out.println("Using Area Method: " + (arePointsCollinearByArea(x1, y1, x2, y2, x3, y3) ? "Collinear" : "Not Collinear"));
    }
}
