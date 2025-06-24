import java.util.HashSet;
import java.util.Set;

public class OTPGenerator {

   
    public static int generateOTP() {
        return (int) (Math.random() * 900000) + 100000;
    }

   
    public static boolean areUnique(int[] otps) {
        Set<Integer> set = new HashSet<>();
        for (int otp : otps) {
            if (!set.add(otp)) {
                return false;             }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] otpArray = new int[10];

        
        for (int i = 0; i < 10; i++) {
            otpArray[i] = generateOTP();
        }

        
        System.out.println("Generated OTPs:");
        for (int otp : otpArray) {
            System.out.println(otp);
        }

        
        if (areUnique(otpArray)) {
            System.out.println("All OTPs are unique.");
        } else {
            System.out.println("Some OTPs are duplicates.");
        }
    }
}
