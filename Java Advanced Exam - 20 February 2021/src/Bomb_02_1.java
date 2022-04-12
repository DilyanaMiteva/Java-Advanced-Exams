import java.util.Scanner;

public class Bomb_02_1 {
    static int stRow;
    static int sttCol;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        String[] data = scan.nextLine().split(",\\s*");
        char[][] matrix = readMatrix(scan, size);
        int bombs = Remaining(matrix);
        for (String cmd : data) {
            matrix[stRow][sttCol] = '+';
            switch (cmd) {
                case "up":
                    stRow--;
                    if (stRow < 0) {
                        stRow++;
                    }
                    break;
                case "down":
                    stRow++;
                    if (stRow >= matrix.length) {
                        stRow--;
                    }
                    break;
                case "left":
                    sttCol--;
                    if (sttCol < 0) {
                        sttCol++;
                    }
                    break;
                case "right":
                    sttCol++;
                    if (sttCol >= matrix.length) {
                        sttCol--;
                    }
                    break;
            }
            if (matrix[stRow][sttCol] == 'e') {
                System.out.printf("END! %d bombs left on the field%n", bombs);
                return;
            } else if (matrix[stRow][sttCol] == 'B') {
                System.out.println("You found a bomb!");
                bombs--;
            }
            matrix[stRow][sttCol] = 's';
            if (bombs == 0) {
                break;
            }
        }
        if (bombs > 0) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)%n", bombs, stRow, sttCol);
        } else {
            System.out.println("Congratulations! You found all bombs!");
        }
    }

    public static int Remaining(char[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    count++;
                }
            }
        }
        return count;
    }

    private static char[][] readMatrix(Scanner scan, int size) {
        char[][] charMatrix = new char[size][size];
        for (int i = 0; i < charMatrix.length; i++) {
            String input = scan.nextLine();
            input = input.replaceAll("\\s+", "");
            charMatrix[i] = input.toCharArray();
            if (input.contains("s")) {
                stRow = i;
                sttCol = input.indexOf("s");
            }
        }
        return charMatrix;
    }
}
