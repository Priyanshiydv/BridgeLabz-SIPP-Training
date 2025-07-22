import java.util.*;

// === Step 1: Define a MealPlan interface ===
interface MealPlan {
    String getPlanName();
    List<String> getMeals();
}

// === Step 2: Subtypes of MealPlan ===
class VegetarianMeal implements MealPlan {
    public String getPlanName() {
        return "Vegetarian Plan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Paneer Curry", "Dal Tadka", "Chapati", "Salad");
    }
}

class VeganMeal implements MealPlan {
    public String getPlanName() {
        return "Vegan Plan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Tofu Stir-Fry", "Quinoa Salad", "Fruit Bowl");
    }
}

class KetoMeal implements MealPlan {
    public String getPlanName() {
        return "Keto Plan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Grilled Chicken", "Avocado Salad", "Boiled Eggs");
    }
}

class HighProteinMeal implements MealPlan {
    public String getPlanName() {
        return "High Protein Plan";
    }

    public List<String> getMeals() {
        return Arrays.asList("Protein Shake", "Boiled Eggs", "Grilled Fish", "Nuts");
    }
}

// === Step 3: Generic Meal Handler ===
class Meal<T extends MealPlan> {
    private T mealPlan;

    public Meal(T mealPlan) {
        this.mealPlan = mealPlan;
    }

    public T getMealPlan() {
        return mealPlan;
    }

    public void displayMealPlan() {
        System.out.println("Meal Plan: " + mealPlan.getPlanName());
        for (String meal : mealPlan.getMeals()) {
            System.out.println("- " + meal);
        }
    }
}

// === Step 4: Generic Utility to Validate and Generate Meal Plan ===
class MealPlanner {
    // Generic method with bounded type parameter
    public static <T extends MealPlan> Meal<T> generateMealPlan(T plan) {
        // You could add additional validation logic here if needed
        System.out.println("Generating personalized plan for: " + plan.getPlanName());
        return new Meal<>(plan);
    }
}

// === Step 5: Main Class to Run the System ===
public class MealPlanGenerator {
    public static void main(String[] args) {
        // User selects meal types
        VegetarianMeal veg = new VegetarianMeal();
        KetoMeal keto = new KetoMeal();
        VeganMeal vegan = new VeganMeal();
        HighProteinMeal highProtein = new HighProteinMeal();

        // Generate and display each personalized plan
        Meal<VegetarianMeal> vegPlan = MealPlanner.generateMealPlan(veg);
        Meal<KetoMeal> ketoPlan = MealPlanner.generateMealPlan(keto);
        Meal<VeganMeal> veganPlan = MealPlanner.generateMealPlan(vegan);
        Meal<HighProteinMeal> highProteinPlan = MealPlanner.generateMealPlan(highProtein);

        System.out.println("\n=== Your Personalized Meal Plans ===\n");

        vegPlan.displayMealPlan();
        System.out.println();

        ketoPlan.displayMealPlan();
        System.out.println();

        veganPlan.displayMealPlan();
        System.out.println();

        highProteinPlan.displayMealPlan();
    }
}
