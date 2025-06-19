public class NumCheck3 {

    
    public static boolean isPerfect(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum == n;
    }

    
    public static boolean isAbundant(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum > n;
    }

    
    public static boolean isDeficient(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) sum += i;
        }
        return sum < n;
    }

    
    private static int factorial(int digit) {
        int fact = 1;
        for (int i = 1; i <= digit; i++) fact *= i;
        return fact;
    }

    
    public static boolean isStrong(int n) {
        int sumFact = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sumFact += factorial(digit);
            temp /= 10;
        }
        return sumFact == n;
    }

    public static void main(String[] args) {
        int[] testNumbers = {6, 12, 15, 145};

        for (int num : testNumbers) {
            System.out.println("Number: " + num);
            System.out.println("Perfect? " + isPerfect(num));
            System.out.println("Abundant? " + isAbundant(num));
            System.out.println("Deficient? " + isDeficient(num));
            System.out.println("Strong? " + isStrong(num));
            System.out.println("-----------------------------");
        }
    }
}
