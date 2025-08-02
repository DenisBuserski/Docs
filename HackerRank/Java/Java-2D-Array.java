import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = new int[6][6];
        fillMatrix(scanner, matrix, 6, 6);

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int rowMatrix = 0;
        int colMatrix = 0;

        while (colMatrix < 4) {
            while (rowMatrix < 4) {
                sum = getSum(matrix, rowMatrix, colMatrix);

                maxSum = Math.max(sum, maxSum);

                rowMatrix++;
            }
            rowMatrix = 0;
            colMatrix++;
        }

        System.out.println(maxSum);
    }

    public static int getSum(int[][] matrix, int rowMatrix, int colMatrix) {
        int sum;
        sum = 0;
        for (int row = rowMatrix; row < rowMatrix + 3; row++) {
            for (int col = colMatrix; col < colMatrix + 3; col++) {
                if (row == rowMatrix + 1 && col == colMatrix || row == rowMatrix + 1 && col == colMatrix + 2) {
                    continue;
                } else {
                    sum += matrix[row][col];
                }
            }
        }
        return sum;
    }

    private static void fillMatrix(Scanner scanner, int[][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
