// Class to check if a text is a palindrome
class PalindromeChecker {
    String text;  // Text to be checked

    // Constructor to set the text
    PalindromeChecker(String text) {
        this.text = text;
    }

    // Method to check if the text is a palindrome
    boolean isPalindrome() {
        String reversed = ""; // Variable to store reversed text

        // Reversing the text
        for (int i = text.length() - 1; i >= 0; i--) {
            reversed += text.charAt(i);
        }

        // Comparing original and reversed text (ignoring case)
        return text.equalsIgnoreCase(reversed);
    }

    // Method to display the result
    void displayResult() {
        if (isPalindrome()) {
            System.out.println(text + " is a Palindrome.");
        } else {
            System.out.println(text + " is NOT a Palindrome.");
        }
    }

    // Main method to run the program
    public static void main(String[] args) {
        PalindromeChecker pc = new PalindromeChecker("Madam");
        pc.displayResult();
    }
}
