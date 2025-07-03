import java.util.Scanner;

class Item {
    String itemName;
    int itemId;
    int quantity;
    double price;
    Item next;

    public Item(String itemName, int itemId, int quantity, double price) {
        this.itemName = itemName;
        this.itemId = itemId;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    private Item head;

    // Add at beginning
    public void addAtBeginning(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        newItem.next = head;
        head = newItem;
    }

    // Add at end
    public void addAtEnd(String name, int id, int qty, double price) {
        Item newItem = new Item(name, id, qty, price);
        if (head == null) {
            head = newItem;
        } else {
            Item temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newItem;
        }
    }

    // Add at position (1-based index)
    public void addAtPosition(int pos, String name, int id, int qty, double price) {
        if (pos <= 1) {
            addAtBeginning(name, id, qty, price);
            return;
        }

        Item newItem = new Item(name, id, qty, price);
        Item temp = head;
        int count = 1;

        while (count < pos - 1 && temp != null) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            System.out.println("Position out of range. Adding at end.");
            addAtEnd(name, id, qty, price);
        } else {
            newItem.next = temp.next;
            temp.next = newItem;
        }
    }

    // Remove by ID
    public void removeById(int id) {
        if (head == null) return;

        if (head.itemId == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        Item temp = head;
        while (temp.next != null && temp.next.itemId != id) {
            temp = temp.next;
        }

        if (temp.next == null) {
            System.out.println("Item ID not found.");
        } else {
            temp.next = temp.next.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity
    public void updateQuantity(int id, int newQty) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item ID not found.");
    }

    // Search by ID
    public void searchById(int id) {
        Item temp = head;
        while (temp != null) {
            if (temp.itemId == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    public void searchByName(String name) {
        Item temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.itemName.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("Item not found.");
    }

    // Total inventory value
    public void calculateTotalValue() {
        double total = 0;
        Item temp = head;
        while (temp != null) {
            total += temp.price * temp.quantity;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Display all items
    public void displayInventory() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        Item temp = head;
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    private void displayItem(Item item) {
        System.out.println("ID: " + item.itemId + ", Name: " + item.itemName + ", Qty: " + item.quantity + ", Price: ₹" + item.price);
    }

    // Sort by Name or Price
    public void sortInventory(String field, boolean ascending) {
        head = mergeSort(head, field, ascending);
        System.out.println("Inventory sorted by " + field + " in " + (ascending ? "ascending" : "descending") + " order.");
    }

    private Item mergeSort(Item head, String field, boolean ascending) {
        if (head == null || head.next == null)
            return head;

        Item middle = getMiddle(head);
        Item nextOfMiddle = middle.next;
        middle.next = null;

        Item left = mergeSort(head, field, ascending);
        Item right = mergeSort(nextOfMiddle, field, ascending);

        return sortedMerge(left, right, field, ascending);
    }

    private Item sortedMerge(Item a, Item b, String field, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        Item result;
        boolean condition;

        if (field.equalsIgnoreCase("name")) {
            condition = ascending ? a.itemName.compareToIgnoreCase(b.itemName) <= 0 : a.itemName.compareToIgnoreCase(b.itemName) > 0;
        } else {
            condition = ascending ? a.price <= b.price : a.price > b.price;
        }

        if (condition) {
            result = a;
            result.next = sortedMerge(a.next, b, field, ascending);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, field, ascending);
        }

        return result;
    }

    private Item getMiddle(Item head) {
        if (head == null) return head;
        Item slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();

        while (true) {
            System.out.println("\n--- Inventory Management Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display Inventory");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort Inventory by Name/Price");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1: case 2: case 3:
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Item ID: ");
                    int id = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int qty = sc.nextInt();
                    System.out.print("Enter Price: ");
                    double price = sc.nextDouble();

                    if (choice == 1)
                        inventory.addAtBeginning(name, id, qty, price);
                    else if (choice == 2)
                        inventory.addAtEnd(name, id, qty, price);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        inventory.addAtPosition(pos, name, id, qty, price);
                    }
                    break;

                case 4:
                    System.out.print("Enter Item ID to remove: ");
                    int removeId = sc.nextInt();
                    inventory.removeById(removeId);
                    break;

                case 5:
                    System.out.print("Enter Item ID to update quantity: ");
                    int updateId = sc.nextInt();
                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();
                    inventory.updateQuantity(updateId, newQty);
                    break;

                case 6:
                    System.out.print("Enter Item ID to search: ");
                    int searchId = sc.nextInt();
                    inventory.searchById(searchId);
                    break;

                case 7:
                    System.out.print("Enter Item Name to search: ");
                    String searchName = sc.nextLine();
                    inventory.searchByName(searchName);
                    break;

                case 8:
                    inventory.displayInventory();
                    break;

                case 9:
                    inventory.calculateTotalValue();
                    break;

                case 10:
                    System.out.print("Sort by (name/price): ");
                    String field = sc.nextLine();
                    System.out.print("Order (asc/desc): ");
                    String order = sc.nextLine();
                    boolean asc = order.equalsIgnoreCase("asc");
                    inventory.sortInventory(field, asc);
                    break;

                case 11:
                    System.out.println("Exiting Inventory Manager...");
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
