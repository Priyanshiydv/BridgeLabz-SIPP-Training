import java.util.*;

public class ShoppingCart {
    private Map<String, Double> productPrices = new HashMap<>();
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();

    // Add product to catalog
    public void addProduct(String product, double price) {
        productPrices.put(product, price);
    }

    // Add product to cart
    public void addToCart(String product, int quantity) {
        if (productPrices.containsKey(product)) {
            cart.put(product, cart.getOrDefault(product, 0) + quantity);
        } else {
            System.out.println("Product not found: " + product);
        }
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("\nCart Items (Insertion Order):");
        for (String product : cart.keySet()) {
            System.out.println(product + " x " + cart.get(product));
        }
    }

    // Display cart sorted by price using TreeMap
    public void displayCartByPrice() {
        System.out.println("\nCart Items (Sorted by Price):");
        TreeMap<Double, String> priceMap = new TreeMap<>();
        for (String product : cart.keySet()) {
            priceMap.put(productPrices.get(product), product);
        }

        for (Map.Entry<Double, String> entry : priceMap.entrySet()) {
            System.out.println(entry.getValue() + " -> ₹" + entry.getKey());
        }
    }

    public static void main(String[] args) {
        ShoppingCart sc = new ShoppingCart();

        sc.addProduct("Shoes", 2000);
        sc.addProduct("Shirt", 1500);
        sc.addProduct("Watch", 3000);

        sc.addToCart("Shirt", 1);
        sc.addToCart("Watch", 1);
        sc.addToCart("Shoes", 2);

        sc.displayCartInOrder();
        sc.displayCartByPrice();
    }
}
