public class CircularTour {
    // Petrol pump class
    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int p, int d) {
            petrol = p;
            distance = d;
        }
    }

    static int findStartPoint(PetrolPump[] pumps) {
        int start = 0, deficit = 0, balance = 0;

        for (int i = 0; i < pumps.length; i++) {
            balance += pumps[i].petrol - pumps[i].distance;

            if (balance < 0) {
                start = i + 1;       // Try next pump
                deficit += balance; // Store shortfall
                balance = 0;
            }
        }

        return (balance + deficit >= 0) ? start : -1;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        System.out.println(findStartPoint(pumps)); // Output: 1
    }
}
