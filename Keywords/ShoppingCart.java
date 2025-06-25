public class ShoppingCart {

    static class Product {
        static double discount = 10.0; // Shared discount for all products

        private final String productID;
        private String productName;
        private double price;
        private int quantity;

        public Product(String productID, String productName, double price, int quantity) {
            this.productID = productID;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        public static void updateDiscount(double newDiscount) {
            discount = newDiscount;
        }

        public void displayProductDetails() {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: $" + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product("P101", "Shoes", 2500, 2);
        Product p2 = new Product("P102", "Watch", 3500, 1);

        if (p1 instanceof Product) p1.displayProductDetails();
        if (p2 instanceof Product) p2.displayProductDetails();

        Product.updateDiscount(15.0); // Update discount
    }
}
