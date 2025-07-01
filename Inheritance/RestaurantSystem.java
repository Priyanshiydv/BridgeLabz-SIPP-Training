// Superclass
class Person {
    String name;
    int id;

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties(); // abstract method
}

// Subclass: Chef (inherits Person, implements Worker)
class Chef extends Person implements Worker {
    Chef(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is preparing delicious meals.");
    }
}

// Subclass: Waiter (inherits Person, implements Worker)
class Waiter extends Person implements Worker {
    Waiter(String name, int id) {
        super(name, id);
    }

    public void performDuties() {
        System.out.println(name + " is serving food to customers.");
    }
}

// Main class
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Priyanshi", 101);
        Waiter waiter = new Waiter("Aryan", 102);

        chef.displayInfo();
        chef.performDuties();
        System.out.println("---------------------------");
        waiter.displayInfo();
        waiter.performDuties();
    }
}
