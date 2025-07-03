import java.util.*;

class User {
    int userId;
    String name;
    int age;
    ArrayList<Integer> friendIds;
    User next;

    public User(int userId, String name, int age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
        this.friendIds = new ArrayList<>();
        this.next = null;
    }
}

class SocialMedia {
    private User head = null;

    // Add a new user
    public void addUser(int id, String name, int age) {
        User newUser = new User(id, name, age);
        if (head == null) {
            head = newUser;
        } else {
            User temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newUser;
        }
    }

    // Find user by ID
    private User findUserById(int id) {
        User temp = head;
        while (temp != null) {
            if (temp.userId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    // Add a friend connection between two users
    public void addFriendConnection(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        if (!u1.friendIds.contains(userId2)) u1.friendIds.add(userId2);
        if (!u2.friendIds.contains(userId1)) u2.friendIds.add(userId1);

        System.out.println("Friend connection added between " + u1.name + " and " + u2.name);
    }

    // Remove a friend connection
    public void removeFriendConnection(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        u1.friendIds.remove(Integer.valueOf(userId2));
        u2.friendIds.remove(Integer.valueOf(userId1));
        System.out.println("Friend connection removed.");
    }

    // Find mutual friends
    public void findMutualFriends(int userId1, int userId2) {
        User u1 = findUserById(userId1);
        User u2 = findUserById(userId2);
        if (u1 == null || u2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        Set<Integer> mutual = new HashSet<>(u1.friendIds);
        mutual.retainAll(u2.friendIds);

        if (mutual.isEmpty()) {
            System.out.println("No mutual friends.");
        } else {
            System.out.println("Mutual Friends:");
            for (int id : mutual) {
                User mutualUser = findUserById(id);
                if (mutualUser != null)
                    System.out.println("- " + mutualUser.name + " (ID: " + mutualUser.userId + ")");
            }
        }
    }

    // Display all friends of a user
    public void displayFriends(int userId) {
        User user = findUserById(userId);
        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (user.friendIds.isEmpty()) {
            System.out.println(user.name + " has no friends.");
            return;
        }

        System.out.println(user.name + "'s friends:");
        for (int id : user.friendIds) {
            User friend = findUserById(id);
            if (friend != null)
                System.out.println("- " + friend.name + " (ID: " + friend.userId + ")");
        }
    }

    // Search by name
    public void searchByName(String name) {
        User temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                System.out.println("Found: ID=" + temp.userId + ", Age=" + temp.age);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("User not found.");
    }

    // Search by ID
    public void searchById(int id) {
        User user = findUserById(id);
        if (user != null) {
            System.out.println("Found: " + user.name + ", Age=" + user.age);
        } else {
            System.out.println("User not found.");
        }
    }

    // Count number of friends for each user
    public void countAllFriends() {
        User temp = head;
        while (temp != null) {
            System.out.println(temp.name + " has " + temp.friendIds.size() + " friend(s).");
            temp = temp.next;
        }
    }

    // Display all users
    public void displayAllUsers() {
        User temp = head;
        System.out.println("\nAll Users:");
        while (temp != null) {
            System.out.println("ID: " + temp.userId + ", Name: " + temp.name + ", Age: " + temp.age);
            temp = temp.next;
        }
    }
}
public class SocialMediaApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SocialMedia sm = new SocialMedia();

        while (true) {
            System.out.println("\n--- Social Media Menu ---");
            System.out.println("1. Add User");
            System.out.println("2. Add Friend Connection");
            System.out.println("3. Remove Friend Connection");
            System.out.println("4. Display User's Friends");
            System.out.println("5. Find Mutual Friends");
            System.out.println("6. Search User by Name");
            System.out.println("7. Search User by ID");
            System.out.println("8. Count Friends for All Users");
            System.out.println("9. Display All Users");
            System.out.println("10. Exit");
            System.out.print("Enter option: ");
            int op = sc.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sm.addUser(id, name, age);
                    break;
                case 2:
                    System.out.print("Enter User ID 1: ");
                    int uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    int uid2 = sc.nextInt();
                    sm.addFriendConnection(uid1, uid2);
                    break;
                case 3:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    sm.removeFriendConnection(uid1, uid2);
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    id = sc.nextInt();
                    sm.displayFriends(id);
                    break;
                case 5:
                    System.out.print("Enter User ID 1: ");
                    uid1 = sc.nextInt();
                    System.out.print("Enter User ID 2: ");
                    uid2 = sc.nextInt();
                    sm.findMutualFriends(uid1, uid2);
                    break;
                case 6:
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    sm.searchByName(name);
                    break;
                case 7:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt();
                    sm.searchById(id);
                    break;
                case 8:
                    sm.countAllFriends();
                    break;
                case 9:
                    sm.displayAllUsers();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
