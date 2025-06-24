// Product class demonstrating instance vs class variables/methods
class Product {
    // Instance variables (each object has its own copy)
    String productName;
    double price;

    // Class variable (shared among all objects of Product)
    static int totalProducts = 0;

    // Constructor to initialize a product
    Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment count whenever a new product is created
    }

    // Instance method to display product details
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: ₹" + price);
    }

    // Class (static) method to display total products created
    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 25000);

        p1.displayProductDetails();
        p2.displayProductDetails();

        // Display total number of products (using class method)
        Product.displayTotalProducts();
    }
}
