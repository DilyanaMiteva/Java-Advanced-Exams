import java.util.*;
import java.util.stream.Collectors;

public class Cooking_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> liquids = Arrays.stream(scan.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::push);

        int countBread = 0, countCake = 0, countPastry = 0, countFruit = 0;

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int valueLiquids = liquids.poll();
            int valueIngredients = ingredients.pop();
            if (valueLiquids + valueIngredients == 25) {
                countBread++;
            } else if (valueLiquids + valueIngredients == 50) {
                countCake++;
            } else if (valueLiquids + valueIngredients == 75) {
                countPastry++;
            } else if (valueLiquids + valueIngredients == 100) {
                countFruit++;
            } else {
                ingredients.push(valueIngredients + 3);
            }
        }
        if (countBread != 0 && countCake != 0 && countFruit != 0 && countPastry != 0) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to to cook everything.");
        }
        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            System.out.printf("Liquids left: %s%n", liquids.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            System.out.printf("Ingredients left: %s%n", ingredients.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.printf("Bread: %d%nCake: %d%nFruit Pie: %d%nPastry: %d%n", countBread, countCake, countFruit, countPastry);
    }
}
