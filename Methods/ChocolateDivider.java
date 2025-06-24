import java.util.Scanner;

public class ChocolateDivider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of chocolates: ");
        int chocolates = sc.nextInt();

        System.out.print("Enter number of children: ");
        int children = sc.nextInt();

        int[] result = findRemainderAndQuotient(chocolates, children);

        System.out.println("Each child gets " + result[1] + " chocolates.");
        System.out.println("Remaining chocolates: " + result[0]);
    }

    public static int[] findRemainderAndQuotient(int total, int divisor) {
        int remainder = total % divisor;
        int quotient = total / divisor;
        return new int[]{remainder, quotient};
    }
}
