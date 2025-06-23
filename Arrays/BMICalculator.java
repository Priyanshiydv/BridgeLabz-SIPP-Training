import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Take input for the number of persons
        System.out.print("Enter the number of persons: ");
        int number = sc.nextInt();

        // 2. Create array to store weight, height and BMI
        double[][] personData = new double[number][3]; // 0 = weight, 1 = height, 2 = BMI
        String[] weightStatus = new String[number];

        // 3. Input data for each person
        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for person " + (i + 1) + ":");

            // Input weight
            double weight;
            do {
                System.out.print("Enter weight in kg (positive): ");
                weight = sc.nextDouble();
            } while (weight <= 0);

            // Input height
            double height;
            do {
                System.out.print("Enter height in meters (positive): ");
                height = sc.nextDouble();
            } while (height <= 0);

            // Calculate BMI
            double bmi = weight / (height * height);

            // Store data
            personData[i][0] = weight;
            personData[i][1] = height;
            personData[i][2] = bmi;

            // Determine weight status
            if (bmi < 18.5)
                weightStatus[i] = "Underweight";
            else if (bmi < 24.9)
                weightStatus[i] = "Normal weight";
            else if (bmi < 29.9)
                weightStatus[i] = "Overweight";
            else
                weightStatus[i] = "Obese";
        }

        // 4. Display the results
        System.out.println("\n--------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s\n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }
    }
}
