import java.util.Scanner;

public class EmployeeBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int EMPLOYEES = 10;

        // Step 2: Arrays to store salary and years of service
        double[] salary = new double[EMPLOYEES];
        double[] yearsOfService = new double[EMPLOYEES];

        // Step 3: Arrays to store bonus and new salary
        double[] bonus = new double[EMPLOYEES];
        double[] newSalary = new double[EMPLOYEES];

        // Totals
        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        // Step 4: Input loop
        for (int i = 0; i < EMPLOYEES; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            // Input salary
            System.out.print("Enter salary: ");
            double sal = sc.nextDouble();
            if (sal <= 0) {
                System.out.println("Invalid salary! Please enter again.");
                i--;
                continue;
            }

            // Input years of service
            System.out.print("Enter years of service: ");
            double yos = sc.nextDouble();
            if (yos < 0) {
                System.out.println("Invalid years of service! Please enter again.");
                i--;
                continue;
            }

            salary[i] = sal;
            yearsOfService[i] = yos;
        }

        // Step 5: Calculate bonus, new salary, totals
        for (int i = 0; i < EMPLOYEES; i++) {
            if (yearsOfService[i] > 5) {
                bonus[i] = 0.05 * salary[i]; // 5% bonus
            } else {
                bonus[i] = 0.02 * salary[i]; // 2% bonus
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        // Step 6: Display results
        System.out.println("\n--------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-10s %-15s\n", "Employee", "Old Salary", "Bonus", "New Salary");
        System.out.println("--------------------------------------------------------------");

        for (int i = 0; i < EMPLOYEES; i++) {
            System.out.printf("%-10d %-15.2f %-10.2f %-15.2f\n",
                    (i + 1), salary[i], bonus[i], newSalary[i]);
        }

        System.out.println("--------------------------------------------------------------");
        System.out.printf("Total Bonus Payout: ₹%.2f\n", totalBonus);
        System.out.printf("Total Old Salary: ₹%.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: ₹%.2f\n", totalNewSalary);
    }
}
