public class NumCheck4 {

    // 1. Check prime number
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 2. Check neon number
    // sum of digits of square == number
    public static boolean isNeon(int n) {
        int square = n * n;
        int sum = 0;
        while (square > 0) {
            sum += square % 10;
            square /= 10;
        }
        return sum == n;
    }

    // 3. Check spy number (sum of digits == product of digits)
    public static boolean isSpy(int n) {
        int sum = 0, product = 1;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }
        return sum == product;
    }

    // 4. Check automorphic number (square ends with number)
    public static boolean isAutomorphic(int n) {
        int square = n * n;
        String nStr = String.valueOf(n);
        String squareStr = String.valueOf(square);
        return squareStr.endsWith(nStr);
    }

    // 5. Check buzz number (divisible by 7 or ends with 7)
    public static boolean isBuzz(int n) {
        return (n % 7 == 0) || (n % 10 == 7);
    }

    // Main method to test above
    public static void main(String[] args) {
        int[] testNumbers = {7, 9, 19, 153, 25, 49, 370};

        for (int num : testNumbers) {
            System.out.println("Number: " + num);
            System.out.println("Prime? " + isPrime(num));
            System.out.println("Neon? " + isNeon(num));
            System.out.println("Spy? " + isSpy(num));
            System.out.println("Automorphic? " + isAutomorphic(num));
            System.out.println("Buzz? " + isBuzz(num));
            System.out.println("---------------------------------");
        }
    }
}
