public class NumberChecker {

    // 1. Count digits in a number
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    // 2. Store digits in an array
    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    // 3. Sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += d;
        }
        return sum;
    }

    // 4. Sum of squares of digits
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int d : digits) {
            sum += Math.pow(d, 2);
        }
        return sum;
    }

    // 5. Check if number is Harshad (divisible by sum of digits)
    public static boolean isHarshad(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }

    // 6. Frequency of each digit stored in 2D array
    public static int[][] digitFrequency(int[] digits) {
        int[] freq = new int[10];
        for (int d : digits) {
            freq[d]++;
        }

        int count = 0;
        for (int f : freq) if (f > 0) count++;

        int[][] result = new int[count][2];
        int idx = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                result[idx][0] = i;
                result[idx][1] = freq[i];
                idx++;
            }
        }
        return result;
    }

    // Method to print 2D frequency array
    public static void printFrequencyArray(int[][] freqArray) {
        System.out.println("Digit | Frequency");
        for (int[] row : freqArray) {
            System.out.println("  " + row[0] + "    |    " + row[1]);
        }
    }

    // Main method to test
    public static void main(String[] args) {
        int number = 22144;

        System.out.println("Number: " + number);
        System.out.println("Digit Count: " + countDigits(number));

        int[] digits = getDigits(number);

        System.out.print("Digits: ");
        for (int d : digits) {
            System.out.print(d + " ");
        }
        System.out.println();

        System.out.println("Sum of digits: " + sumOfDigits(digits));
        System.out.println("Sum of squares of digits: " + sumOfSquares(digits));
        System.out.println("Is Harshad? " + (isHarshad(number, digits) ? "Yes" : "No"));

        System.out.println("Digit Frequency:");
        printFrequencyArray(digitFrequency(digits));
    }
}
