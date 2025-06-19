import java.util.Random;

public class MatrixOperation {

    
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); // numbers between 0-9
            }
        }
        return matrix;
    }

    
    public static int[][] add(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    
    public static int[][] subtract(int[][] a, int[][] b) {
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    
    public static int[][] multiply(int[][] a, int[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int rowsB = b.length;
        int colsB = b[0].length;

        if (colsA != rowsB) {
            throw new IllegalArgumentException("Cannot multiply: Columns of A != Rows of B");
        }

        int[][] result = new int[rowsA][colsB];
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                int sum = 0;
                for (int k = 0; k < colsA; k++) {
                    sum += a[i][k] * b[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        
        int[][] matrixA = createRandomMatrix(3, 2);
        int[][] matrixB = createRandomMatrix(3, 2);

        System.out.println("Matrix A:");
        printMatrix(matrixA);

        System.out.println("Matrix B:");
        printMatrix(matrixB);

        
        int[][] sum = add(matrixA, matrixB);
        System.out.println("Sum (A + B):");
        printMatrix(sum);

        
        int[][] diff = subtract(matrixA, matrixB);
        System.out.println("Difference (A - B):");
        printMatrix(diff);

        
        int[][] matrixC = createRandomMatrix(2, 3);
        System.out.println("Matrix C (for multiplication):");
        printMatrix(matrixC);

        int[][] product = multiply(matrixA, matrixC);
        System.out.println("Product (A x C):");
        printMatrix(product);
    }
}
