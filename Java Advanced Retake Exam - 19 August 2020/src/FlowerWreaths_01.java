import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class FlowerWreaths_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(lilies::push);
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int wreaths = 0;
        int sumFlowers = 0;


        while (!lilies.isEmpty() && !roses.isEmpty()) {
            if (lilies.peek() + roses.peek() == 15) {
                wreaths++;
                lilies.pop();
                roses.poll();
            } else if (lilies.peek() + roses.peek() > 15) {
                int currentLilies = lilies.peek() - 2;
                lilies.pop();
                if (!lilies.isEmpty()) {
                    lilies.addFirst(currentLilies);
                } else lilies.push(currentLilies);
            } else {
                sumFlowers += lilies.peek() + roses.peek();
                lilies.pop();
                roses.poll();
            }
        }



            while (sumFlowers >= 15) {
                wreaths += 1;
                sumFlowers -= 15;
            }



        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }

    }

}
