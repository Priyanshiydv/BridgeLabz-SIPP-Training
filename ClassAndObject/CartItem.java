// Class to represent an item in the shopping cart
class CartItem {
    String itemName; // Name of the item
    double price;    // Price of one item
    int quantity;    // Quantity of the item

    // Constructor to initialize the cart item
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to display item details and total cost
    void displayItem() {
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per item: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: ₹" + (price * quantity));
    }

    // Main method to run the program
    public static void main(String[] args) {
        CartItem item1 = new CartItem("Laptop", 45000, 1);
        CartItem item2 = new CartItem("Mouse", 500, 2);

        System.out.println("Cart Item 1:");
        item1.displayItem();

        System.out.println("\nCart Item 2:");
        item2.displayItem();

        double grandTotal = (item1.price * item1.quantity) + (item2.price * item2.quantity);
        System.out.println("\nGrand Total = ₹" + grandTotal);
    }
}
