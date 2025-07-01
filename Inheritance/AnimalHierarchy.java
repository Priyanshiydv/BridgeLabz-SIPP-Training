// Superclass
class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void makeSound() {
        System.out.println("Animal makes a sound.");
    }
}

// Subclass: Dog
class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " (Dog): Woof!");
    }
}

// Subclass: Cat
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " (Cat): Meow!");
    }
}

// Subclass: Bird
class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }

    void makeSound() {
        System.out.println(name + " (Bird): Chirp!");
    }
}

public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal a1 = new Dog("Bruno", 5);
        Animal a2 = new Cat("Whiskers", 3);
        Animal a3 = new Bird("Tweety", 1);

        a1.makeSound();
        a2.makeSound();
        a3.makeSound();
    }
}
