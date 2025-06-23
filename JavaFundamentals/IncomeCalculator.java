import java.util.Scanner;

public class IncomeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your salary (INR): ");
        double salary = scanner.nextDouble();

        System.out.print("Enter your bonus (INR): ");
        double bonus = scanner.nextDouble();

        
        double totalIncome = salary + bonus;

        

        System.out.println("The salary is INR " + salary + " and the bonus is INR " + bonus +
                ". Hence Total Income is INR " + totalIncome);
    }
}
