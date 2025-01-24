// import java.util.Scanner;

public class MatrixMul {
    public static void main(String[] args) {

        int A[][] = { { 1, 2 }, { 3, 4 } };
        int B[][] = { { 1, 1 }, { 1, 1 } };

        int rows = A.length;
        int cols = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        int sum[][] = new int[rows][cols];
        int mul[][] = new int[rows][cols];
        int sub[][] = new int[rows][cols];
        // int inv[][] = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = A[i][j] + B[i][j];
                sub[i][j] = A[i][j] - B[i][j];
            }
        }

        // Matrix Multiplication
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colsB; j++) {
                mul[i][j] = 0;
                for (int k = 0; k < cols; k++) {
                    mul[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        // Calculate the Inverse of Matrix A (2x2 only)
        double determinant = (A[0][0] * A[1][1]) - (A[0][1] * A[1][0]);
        if (determinant == 0) {
            System.out.println("\nInverse of matrix A does not exist (determinant is zero).");
        } else {
            double[][] inverse = new double[2][2];
            inverse[0][0] = A[1][1] / determinant;
            inverse[0][1] = -A[0][1] / determinant;
            inverse[1][0] = -A[1][0] / determinant;
            inverse[1][1] = A[0][0] / determinant;

            System.out.println("\nInverse of matrix A:");
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {

                    System.out.print(inverse[i][j]);

                }
            }

        }

        System.out.println("\nSum of matrix: ");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(sum[i][j]);

            }
        }

        System.out.println("\nMul of matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(mul[i][j]);

            }
        }

        System.out.println("\nSub of matrix: ");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                System.out.print(sub[i][j]);

            }
        }

    }
}