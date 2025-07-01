// Base class: Order
class Order {
    String orderId;
    String orderDate;

    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

// Subclass: ShippedOrder extends Order
class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    String getOrderStatus() {
        return "Order Shipped - Tracking Number: " + trackingNumber;
    }
}

// Subclass: DeliveredOrder extends ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }
}

// Main class to test
public class OrderManagement {
    public static void main(String[] args) {
        Order o = new Order("ORD001", "2025-07-01");
        ShippedOrder s = new ShippedOrder("ORD002", "2025-07-02", "TRK12345");
        DeliveredOrder d = new DeliveredOrder("ORD003", "2025-07-03", "TRK67890", "2025-07-05");

        System.out.println(o.getOrderStatus());
        System.out.println(s.getOrderStatus());
        System.out.println(d.getOrderStatus());
    }
}
