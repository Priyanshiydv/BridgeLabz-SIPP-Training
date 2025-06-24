import java.util.Scanner;

class SimpleInterest 
{
    public static void main(String[] args) 
{
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Principal amount: ");
        double principal = sc.nextDouble();

        System.out.print("Enter Rate of interest: ");
        double rate = sc.nextDouble();

        System.out.print("Enter Time (in years): ");
        double time = sc.nextDouble();
       
        double interest = (principal * rate * time) / 100;
        
        System.out.println("Simple Interest is: " + interest);
    }
}
