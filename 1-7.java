/*
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column is set to 0.
 *
 */
package cc150.chapter1;
import java.util.Random;
import java.util.BitSet;

class Test1_7 {
    public static void main(String argv[]) {
        int M = 3, N = 3;
        switch( argv.length ) {
        case 2:
            N = Integer.parseInt(argv[1]);
        case 1:
            M = Integer.parseInt(argv[0]);
            break;
        }
        System.out.printf("%dx%d matrix\n", M, N);

        // Initialize matrix with random numbers
        int[][] matrix = new int[M][N];
        Random rand = new Random(System.currentTimeMillis());
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                matrix[i][j] = rand.nextInt(N);
            }
        }
        printMatrix(M, N, matrix);
        // Set row and column masks where there is a zero
        // TODO: Use bitmap instead of int array
        //int row[] = new int[M];
        //int column[] = new int[N];
        BitSet row = new BitSet(M);
        BitSet column = new BitSet(N);
        row.clear(); column.clear();
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if( matrix[i][j] == 0 ) {
                    //row[i] = 1;
                    //column[j] = 1;
                    row.set(i);
                    column.set(j);
                }
            }
        }
        // Clear rows
        for(int i = 0; i < M; i++) {
            if( row.get(i) ) {
                for(int j = 0; j < N; j++) matrix[i][j] = 0;
            }
        }
        for(int i = 0; i < N; i++) {
            if( column.get(i) ) {
                for(int j = 0; j < M; j++) matrix[j][i] = 0;
            }
        }
        // Clear columns
        System.out.println("-----------------------------------------------------");
        printMatrix(M, N, matrix);
    }
    public static void printMatrix(int m, int n, int matrix[][]) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%2d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
