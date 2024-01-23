import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

class Recipe {
    private String name;
    private Map<String, String> ingredients;
    private String instructions;

    public Recipe(String name, Map<String, String> ingredients, String instructions) {
        this.name = name;
        this.ingredients = new HashMap<>(ingredients);
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getIngredients() {
        return new HashMap<>(ingredients);
    }

    public String getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "Recipe: " + name + "\nIngredients: " + ingredients + "\nInstructions: " + instructions;
    }
}

class RecipeFinder {
    private ArrayList<Recipe> recipes;

    public RecipeFinder() {
        this.recipes = new ArrayList<>();
        initializeRecipes();
    }

    private void initializeRecipes() {
        // Add sample healthy recipes
        Map<String, String> saladIngredients = new HashMap<>();
        saladIngredients.put("Lettuce", "1 cup");
        saladIngredients.put("Tomatoes", "1/2 cup");
        saladIngredients.put("Cucumber", "1/2 cup");
        saladIngredients.put("Olive Oil", "1 tablespoon");
        Recipe salad = new Recipe("Simple Salad", saladIngredients, "Mix all ingredients and toss with olive oil.");

        Map<String, String> smoothieIngredients = new HashMap<>();
        smoothieIngredients.put("Banana", "1");
        smoothieIngredients.put("Spinach", "1 cup");
        smoothieIngredients.put("Greek Yogurt", "1/2 cup");
        smoothieIngredients.put("Almond Milk", "1 cup");
        Recipe smoothie = new Recipe("Green Smoothie", smoothieIngredients, "Blend all ingredients until smooth.");

        recipes.add(salad);
        recipes.add(smoothie);
    }

    public Recipe findRandomRecipe() {
        Random random = new Random();
        int index = random.nextInt(recipes.size());
        return recipes.get(index);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeFinder recipeFinder = new RecipeFinder();

        while (true) {
            System.out.println("1. Find Random Healthy Recipe");
            System.out.println("2. Exit");

            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    Recipe randomRecipe = recipeFinder.findRandomRecipe();
                    System.out.println("\n" + randomRecipe);
                    break;

                case 2:
                    System.out.println("Exiting Healthy Recipe Finder. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
