import java.util.Scanner;

public class BMICalculator {

    
    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightCm = data[i][1];
            double heightM = heightCm / 100.0;
            double bmi = weight / (heightM * heightM);
            data[i][2] = bmi;
        }
    }

    
    public static String[] determineBMIStatus(double[][] data) {
        String[] status = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            double bmi = data[i][2];
            if (bmi < 18.5)
                status[i] = "Underweight";
            else if (bmi < 25)
                status[i] = "Normal";
            else if (bmi < 30)
                status[i] = "Overweight";
            else
                status[i] = "Obese";
        }
        return status;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] teamData = new double[10][3]; // [weight, height(cm), bmi]

        
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter data for person " + (i + 1));
            System.out.print("Weight (in kg): ");
            teamData[i][0] = sc.nextDouble();

            System.out.print("Height (in cm): ");
            teamData[i][1] = sc.nextDouble();
        }

        
        calculateBMI(teamData);

        
        String[] bmiStatuses = determineBMIStatus(teamData);

        
        System.out.printf("\n%-10s%-10s%-10s%-15s\n", "Weight", "Height", "BMI", "Status");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10.1f%-10.1f%-10.2f%-15s\n",
                    teamData[i][0], teamData[i][1], teamData[i][2], bmiStatuses[i]);
        }
    }
}
