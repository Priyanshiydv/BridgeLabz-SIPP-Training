// Class to represent an Item in inventory
class Item {
    int itemCode;    // Code of the item
    String itemName; // Name of the item
    double price;    // Price per unit of the item

    // Constructor to set item details
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    // Method to display item details and total cost for given quantity
    void displayDetails(int quantity) {
        double totalCost = quantity * price; // Calculate total cost
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Unit Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + totalCost);
    }

    // Main method to run the program
    public static void main(String[] args) {
        Item i = new Item(2001, "Pen", 10);
        i.displayDetails(5); // Showing details for 5 Pens
    }
}
