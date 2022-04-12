import java.util.Arrays;
import java.util.Scanner;

public class Task_01 {

    private static char[][] charMatrix;
    private static final int[] INDEXES = new int[2];

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int money = 0;

        readMatr(scan, Integer.parseInt(scan.nextLine()));

        findIndexes('S');

        while (money < 50 && INDEXES[0] >= 0 && INDEXES[0] < charMatrix.length && INDEXES[1] >= 0 && INDEXES[1] < charMatrix[INDEXES[0]].length) {

            String input = scan.nextLine();

            charMatrix[INDEXES[0]][INDEXES[1]] = '-';

            switch (input) {
                case "up":
                    INDEXES[0]--;
                    break;
                case "down":
                    INDEXES[0]++;
                    break;
                case "right":
                    INDEXES[1]++;
                    break;
                case "left":
                    INDEXES[1]--;
                    break;
            }

            if (INDEXES[0] >= 0 && INDEXES[0] < charMatrix.length && INDEXES[1] >= 0 && INDEXES[1] < charMatrix[INDEXES[0]].length) {
                if (charMatrix[INDEXES[0]][INDEXES[1]] == 'P') {

                    charMatrix[INDEXES[0]][INDEXES[1]] = '-';
                    findIndexes('P');

                } else if (Character.isDigit(charMatrix[INDEXES[0]][INDEXES[1]])) {

                    money += Integer.parseInt(String.valueOf(charMatrix[INDEXES[0]][INDEXES[1]]));
                }
                charMatrix[INDEXES[0]][INDEXES[1]] = 'S';
            }
        }

        if (INDEXES[0] >= 0 && INDEXES[0] < charMatrix.length && INDEXES[1] >= 0 && INDEXES[1] < charMatrix[INDEXES[0]].length){
            System.out.println("Good news! You succeeded in collecting enough money!");
        } else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }

        System.out.println("Money: " + money);
        Arrays.stream(charMatrix).map(row -> Arrays.toString(row).replaceAll("[\\[\\]]", "")
                .replaceAll(", ", "")).forEach(System.out::println);

    }


    private static void readMatr(Scanner scan, int n) {
        charMatrix = new char[n][];
        for (int row = 0; row < n; row++) {
            charMatrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
    }

    private static void findIndexes(char toFind) {
        boolean isFind = false;
        for (int i = 0; i < charMatrix.length; i++) {
            for (int j = 0; j < charMatrix[0].length; j++) {
                if (charMatrix[i][j] == toFind) {
                    INDEXES[0] = i;
                    INDEXES[1] = j;
                    isFind = true;
                    break;
                }
            }
            if (isFind) {
                break;
            }
        }
    }

}
