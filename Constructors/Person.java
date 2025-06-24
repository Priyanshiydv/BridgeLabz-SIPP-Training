// Person class with copy constructor
class Person {
    String name;
    int age;

    // Parameterized constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Copy constructor
    Person(Person another) {
        this.name = another.name;
        this.age = another.age;
    }

    void displayPerson() {
        System.out.println("Name: " + name + ", Age: " + age);
    }

    public static void main(String[] args) {
        Person p1 = new Person("Alice", 25);
        Person p2 = new Person(p1); // Cloning using copy constructor

        p1.displayPerson();
        p2.displayPerson();
    }
}
