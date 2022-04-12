import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Scheduling_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] threads = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int valueKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int task : tasks) {
            stack.push(task);
        }

        for (int thread : threads) {
            queue.offer(thread);
        }


        while (stack.peek() != valueKill) {
            if (queue.peek() >= stack.peek()) {
                queue.pop();
                stack.poll();
            } else if (queue.peek() < stack.peek()) {
                queue.pop();
            }
        }

        System.out.printf("Thread with value %d killed task %d%n", queue.peek(), valueKill);
        stack.pop();

        for (Integer integer : queue) {
            System.out.print(integer + " ");
        }


    }
}
