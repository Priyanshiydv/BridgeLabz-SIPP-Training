import java.util.*;

// === Category Interfaces for Restriction ===
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Book";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadget";
    }
}

// === Generic Product Class ===
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return category.getCategoryName() + ": " + name + " | Price: ₹" + price;
    }
}

// === Utility Class with Generic Method ===
class MarketplaceUtils {
    // Generic method to apply discount to any Product
    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {
        double oldPrice = product.getPrice();
        double discount = oldPrice * (percentage / 100);
        product.setPrice(oldPrice - discount);
        System.out.println("Discount of " + percentage + "% applied to " + product.getName());
    }
}

// === Main Class to Run the Program ===
public class DynamicMarketplace {
    public static void main(String[] args) {
        // Create product catalog using different categories
        List<Product<? extends Category>> catalog = new ArrayList<>();

        // Add products to catalog
        catalog.add(new Product<>( "The Alchemist", 399.0, new BookCategory()));
        catalog.add(new Product<>( "Denim Jeans", 1299.0, new ClothingCategory()));
        catalog.add(new Product<>( "Bluetooth Speaker", 2499.0, new GadgetCategory()));

        // Display catalog before discount
        System.out.println("=== Product Catalog BEFORE Discount ===");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }

        // Apply discounts using generic method
        MarketplaceUtils.applyDiscount(catalog.get(0), 10); // 10% off on Book
        MarketplaceUtils.applyDiscount(catalog.get(2), 20); // 20% off on Gadget

        // Display catalog after discount
        System.out.println("\n=== Product Catalog AFTER Discount ===");
        for (Product<? extends Category> p : catalog) {
            System.out.println(p);
        }
    }
}
