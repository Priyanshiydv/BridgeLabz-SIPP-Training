import java.util.Scanner;

public class FriendsYoungestTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter Amar's age: ");
        int amarAge = scanner.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = scanner.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = scanner.nextInt();

        
        System.out.print("Enter Amar's height (in cm): ");
        double amarHeight = scanner.nextDouble();
        System.out.print("Enter Akbar's height (in cm): ");
        double akbarHeight = scanner.nextDouble();
        System.out.print("Enter Anthony's height (in cm): ");
        double anthonyHeight = scanner.nextDouble();

        
        int youngestAge = Math.min(amarAge, Math.min(akbarAge, anthonyAge));
        String youngestFriend = "";

        if (youngestAge == amarAge) youngestFriend += "Amar ";
        if (youngestAge == akbarAge) youngestFriend += "Akbar ";
        if (youngestAge == anthonyAge) youngestFriend += "Anthony ";

        
        double tallestHeight = Math.max(amarHeight, Math.max(akbarHeight, anthonyHeight));
        String tallestFriend = "";

        if (tallestHeight == amarHeight) tallestFriend += "Amar ";
        if (tallestHeight == akbarHeight) tallestFriend += "Akbar ";
        if (tallestHeight == anthonyHeight) tallestFriend += "Anthony ";

        System.out.println("Youngest friend(s): " + youngestFriend.trim() + " with age " + youngestAge);
        System.out.println("Tallest friend(s): " + tallestFriend.trim() + " with height " + tallestHeight + " cm");
    }
}
