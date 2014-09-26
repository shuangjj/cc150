/*
 * 1-6.java : Rotate image array by 90 degree in place
 */

package cc150.chapter1;

class Test1_6 {
    private static final int N = 4;
    public static void main(String argv[]) {
        int matrix[][] = new int[N+1][N+1];
        fillLayer(1, 1, N, 1, matrix);
        System.out.println("Finish filling image matrix layer by layer");
        printMatrix(N, matrix);
        // Rotate clockwise by 90 degree
        rotateLayer(1, 1, N, matrix);
        System.out.println("Finish rotating image matrix layer by layer");
        printMatrix(N, matrix);

    }

    public static void printMatrix(int n, int matrix[][]) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void fillLayer(int row, int col, int n, int start, int matrix[][]) {
        if( n < 2) return;
        // Go right
        for(int i = col; i < col + n; i++) {
            matrix[row][i] = start++;
        }
        // Go down
        for(int i = row+1; i < row + n; i++) {
            matrix[i][col+n-1] = start++;
        }
        // Go left
        for(int i = col+n-2; i >= col; i--) {
            matrix[row+n-1][i] = start++;
        }
        // Go up
        for(int i = row+n-2; i > row; i--) {
            matrix[i][col] = start++;
        }
        fillLayer(row+1, col+1, n-2, start, matrix);
    }

    public static void rotateLayer(int row, int col, int n, int matrix[][]) {
        if( n < 2) return;
        for(int i = 0; i < n-1; i++) {
            // shift right to top 
            int tmp = matrix[row][col+i];
            matrix[row][col+i] = matrix[row+i][col+n-1];
            // shift bottom to right
            matrix[row+i][col+n-1] = matrix[row+n-1][col+n-i-1];
            // shift left to bottom
            matrix[row+n-1][col+n-i-1] = matrix[row+n-i-1][col];
            // shift top to left
            matrix[row+n-i-1][col] = tmp;
        }
        rotateLayer(row+1, col+1, n-2, matrix);
    }

} 
