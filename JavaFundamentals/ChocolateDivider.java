import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter number of chocolates: ");
        int numberOfChocolates = scanner.nextInt();

        System.out.print("Enter number of children: ");
        int numberOfChildren = scanner.nextInt();

       
        int chocolatesEach = numberOfChocolates / numberOfChildren;
        int remainingChocolates = numberOfChocolates % numberOfChildren;

        
        System.out.println("The number of chocolates each child gets is " + chocolatesEach +
                " and the number of remaining chocolates is " + remainingChocolates);
    }
}
