import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();

        if (choice == 1) {
            System.out.printf("Temperature in Celsius: %.2f°C%n", fahrenheitToCelsius(temperature));
        } else if (choice == 2) {
            System.out.printf("Temperature in Fahrenheit: %.2f°F%n", celsiusToFahrenheit(temperature));
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    
    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
