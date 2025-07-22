import java.util.*;

// Abstract base class for all warehouse items
abstract class WarehouseItem {
    private String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // Abstract method to be implemented by each subclass
    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + ": " + name;
    }
}

// Subclass representing Electronics items
class Electronics extends WarehouseItem {
    public Electronics(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Electronics";
    }
}

// Subclass representing Groceries items
class Groceries extends WarehouseItem {
    public Groceries(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Groceries";
    }
}

// Subclass representing Furniture items
class Furniture extends WarehouseItem {
    public Furniture(String name) {
        super(name);
    }

    @Override
    public String getCategory() {
        return "Furniture";
    }
}

// Generic Storage class to store any type of WarehouseItem
class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    // Add item to the storage
    public void addItem(T item) {
        items.add(item);
    }

    // Retrieve all stored items
    public List<T> getItems() {
        return items;
    }

    // Static method using wildcard to display any list of WarehouseItem or its subclasses
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }
}

// Main class to test the system
public class SmartWarehouseSystem {
    public static void main(String[] args) {
        // Create storage for different types of warehouse items
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        // Add items to electronics storage
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Smartphone"));

        // Add items to groceries storage
        groceriesStorage.addItem(new Groceries("Rice"));
        groceriesStorage.addItem(new Groceries("Wheat"));

        // Add items to furniture storage
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        // Display items from each storage using wildcard method
        System.out.println("=== Electronics ===");
        Storage.displayItems(electronicsStorage.getItems());

        System.out.println("=== Groceries ===");
        Storage.displayItems(groceriesStorage.getItems());

        System.out.println("=== Furniture ===");
        Storage.displayItems(furnitureStorage.getItems());
    }
}
