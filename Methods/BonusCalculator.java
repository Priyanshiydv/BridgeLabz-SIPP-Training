public class BonusCalculator {

    
    public static int[][] generateEmployees() {
        int[][] employees = new int[10][2]; 
        for (int i = 0; i < 10; i++) {
            employees[i][0] = (int) (Math.random() * 90000) + 10000; 
            employees[i][1] = (int) (Math.random() * 15) + 1; 
        }
        return employees;
    }

    
    public static double[][] calculateBonus(int[][] employees) {
        double[][] result = new double[10][2];
        for (int i = 0; i < 10; i++) {
            double bonusPercent = (employees[i][1] > 5) ? 0.05 : 0.02;
            double bonusAmount = employees[i][0] * bonusPercent;
            double newSalary = employees[i][0] + bonusAmount;
            result[i][0] = newSalary;
            result[i][1] = bonusAmount;
        }
        return result;
    }

    
    public static void displayResults(int[][] employees, double[][] newSalaries) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;

        System.out.printf("%-10s %-10s %-10s %-10s %-10s\n", "Emp#", "OldSal", "Years", "Bonus", "NewSal");

        for (int i = 0; i < 10; i++) {
            totalOldSalary += employees[i][0];
            totalBonus += newSalaries[i][1];
            totalNewSalary += newSalaries[i][0];
            System.out.printf("%-10d %-10d %-10d %-10.2f %-10.2f\n", i + 1, employees[i][0], employees[i][1],
                    newSalaries[i][1], newSalaries[i][0]);
        }

        System.out.println("----------------------------------------------------");
        System.out.printf("%-10s %-10.2f %-10s %-10.2f %-10.2f\n", "Total", totalOldSalary, "",
                totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        int[][] employees = generateEmployees();
        double[][] newSalaries = calculateBonus(employees);
        displayResults(employees, newSalaries);
    }
}
