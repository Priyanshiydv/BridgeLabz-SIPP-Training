public class NumCheck2 {

    
    public static int countDigits(int number) {
        return String.valueOf(Math.abs(number)).length();
    }

    

    public static int[] getDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }
        return digits;
    }

    
    public static int[] reverseDigits(int[] digits) {
        int[] reversed = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            reversed[i] = digits[digits.length - 1 - i];
        }
        return reversed;
    }

   
    public static boolean compareArrays(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) return false;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }

    

    public static boolean isPalindrome(int[] digits) {
        return compareArrays(digits, reverseDigits(digits));
    }

    
    public static boolean isDuckNumber(int[] digits) {
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] == 0) return true;
        }
        return false;
    }

    
    public static void main(String[] args) {
        int number = 1201;

        System.out.println("Number: " + number);

        int[] digits = getDigits(number);
        int[] reversedDigits = reverseDigits(digits);

        System.out.println("Digit Count: " + countDigits(number));

        System.out.print("Digits: ");
        for (int d : digits) System.out.print(d + " ");
        System.out.print("\nReversed Digits: ");
        for (int r : reversedDigits) System.out.print(r + " ");

        System.out.println("\nIs Palindrome? " + isPalindrome(digits));
        System.out.println("Is Duck Number? " + isDuckNumber(digits));
    }
}
