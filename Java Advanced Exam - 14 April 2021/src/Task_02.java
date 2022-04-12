import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Task_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<Integer> tulips = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).forEach(tulips::push);

        //queue
        ArrayDeque<Integer> daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        int bouquets = 0;

        int remainingFlowers = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int currentTulip = tulips.peek();
            int currentDaffodils = daffodils.peek();

            if (currentTulip + currentDaffodils == 15) {
                bouquets++;
                tulips.pop();
                daffodils.poll();
            } else if (currentTulip + currentDaffodils > 15) {
                currentTulip -= 2;
                tulips.pop();
                tulips.push(currentTulip);
            } else {
                remainingFlowers += currentTulip;
                remainingFlowers += currentDaffodils;
                tulips.pop();
                daffodils.poll();
            }

        }

        while (remainingFlowers >= 15){
            bouquets++;
            remainingFlowers -= 15;
        }

        if (bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!",
            bouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.",
                    5 - bouquets);
        }


    }
}
