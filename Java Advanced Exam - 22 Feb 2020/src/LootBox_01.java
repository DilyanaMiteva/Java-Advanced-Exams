import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LootBox_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Queue
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        //Stack
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(secondBox::push);

        int values = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {

            if ((firstBox.peek() + secondBox.peek()) % 2 == 0) {
                int currentElementFromFirstBox = firstBox.poll();
                int currentElementFromSecondBox = secondBox.pop();
                int sum = currentElementFromFirstBox + currentElementFromSecondBox;
                values += sum;
            } else {
                int currentElementFromSecondBox = secondBox.pop();
                firstBox.offer(currentElementFromSecondBox);
            }
        }


        if (firstBox.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        if (values >= 100) {
            System.out.printf("Your loot was epic! Value: %d%n", values);
        } else {
            System.out.printf("Your loot was poor... Value: %d%n", values);
        }

    }
}
