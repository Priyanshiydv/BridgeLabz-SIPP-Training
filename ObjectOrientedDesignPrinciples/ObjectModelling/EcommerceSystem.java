import java.util.*;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void showDetails() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }
}

class Order {
    private int orderId;
    private List<Product> products = new ArrayList<>();

    public Order(int id) {
        this.orderId = id;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId);
        for (Product p : products) {
            p.showDetails();
        }
    }
}

class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order #" + order);
    }

    public void showOrders() {
        System.out.println(name + "'s Orders:");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class EcommerceSystem {
    public static void main(String[] args) {
        Customer john = new Customer("John");

        Product phone = new Product("Smartphone", 20000);
        Product charger = new Product("Charger", 1500);

        Order order1 = new Order(101);
        order1.addProduct(phone);
        order1.addProduct(charger);

        john.placeOrder(order1);

        john.showOrders();
    }
}
