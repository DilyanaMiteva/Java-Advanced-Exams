import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicBox_01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = Arrays.stream(scan.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(secondBox::push);

        int sumItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                sumItems += sum;
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }
        if (sumItems >= 100) {
            System.out.println("Wow, your prey was epic! Value: " + sumItems);
        } else {
            System.out.println("Poor prey... Value: " + sumItems);
        }
    }
}
