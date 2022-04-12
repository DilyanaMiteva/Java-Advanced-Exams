
import java.util.Scanner;

public class Bomb_02 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        String[] commands = scan.nextLine().split(",");
        char[][] matrix = readMatrix(scan, n);
        int[] currentPosition = findIndexes(matrix, 's');
        int leftBombs = 0;

        for (String command : commands) {

            int[] curr = new int[2];
            curr[0] = currentPosition[0];
            curr[1] = currentPosition[1];

            matrix[currentPosition[0]][currentPosition[1]] = '+';

            if ("up".equals(command)) {
                currentPosition[0]--;
            } else if ("down".equals(command)) {
                currentPosition[0]++;
            } else if ("right".equals(command)) {
                currentPosition[1]++;
            } else if ("left".equals(command)) {
                currentPosition[1]--;
            }


            if (indexIsInMatrix(currentPosition, matrix)) {
                if (matrix[currentPosition[0]][currentPosition[1]] == 'B') {
                    System.out.println("You found a bomb!");
                    matrix[currentPosition[0]][currentPosition[1]] = 's';
                } else if (matrix[currentPosition[0]][currentPosition[1]] == 'e') {
                    leftBombs = getLeftBombs(matrix);
                    System.out.printf("END! %d bombs left on the field%n", leftBombs);
                    return;
                }
            } else {

                currentPosition[0] = curr[0];
                currentPosition[1] = curr[1];

            }


        }

        leftBombs = getLeftBombs(matrix);


        if (matrix[currentPosition[0]][currentPosition[1]] != 'e') {
            if (leftBombs != 0) {
                System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n"
                        , leftBombs, currentPosition[0], currentPosition[1]);

            } else {
                System.out.println("Congratulations! You found all bombs!");
            }
        }


    }

    private static int getLeftBombs(char[][] matrix) {
        int leftBombs = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'B') {
                    leftBombs++;
                }
            }
        }
        return leftBombs;
    }

    private static int[] findIndexes(char[][] matrix, char toFind) {
        int[] indexes = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == toFind) {
                    indexes[0] = i;
                    indexes[1] = j;
                }
            }
        }
        return indexes;
    }

    private static char[][] readMatrix(Scanner scan, int n) {
        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            matrix[row] = scan.nextLine().replaceAll("\\s+", "").toCharArray();
        }
        return matrix;
    }

    private static boolean indexIsInMatrix(int[] currentPosition, char[][] matrix) {
        return currentPosition[0] >= 0 && currentPosition[0] < matrix.length
                && currentPosition[1] >= 0 && currentPosition[1] < matrix.length;
    }

}
