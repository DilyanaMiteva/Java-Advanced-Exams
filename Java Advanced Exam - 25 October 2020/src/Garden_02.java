import java.util.Arrays;
import java.util.Scanner;

public class Garden_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] nAndM = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int n = nAndM[0];
        int m = nAndM[1];

        int[][] matrix = new int[n][m];
        int startNumber = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = startNumber;
            }
        }


        String input = scanner.nextLine();
        while (!input.equals("Bloom Bloom Plow")) {
            int[] position = Arrays.stream(input.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();

            int element1 = position[0];
            int element2 = position[1];

            if (element1 >= 0 && element1 < n && element2 >= 0 && element2 < m) {
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if (row == element1 || col == element2) {
                            matrix[row][col] += 1;
                        }
                    }
                }
            } else {
                System.out.println("Invalid coordinates.");
            }


            input = scanner.nextLine();
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}


