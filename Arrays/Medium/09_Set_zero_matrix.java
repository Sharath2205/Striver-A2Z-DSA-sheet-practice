// https://leetcode.com/problems/set-matrix-zeroes/

class Solution {

    /**
     * 
     * BRUTE FORCE:
     * - Take new N * M array and when every a zero occurs at M[i][j] index, update
     * the new array entire i column and j row with -1 (As default value is zero)
     * - After traversal update the matrix array, if newArray[i][j] == -1 then
     * matrix[i][j] = 0
     * 
     * BETTER APPROACH:
     * - Instead of create a new N*M array we can just create an 2 arrays with size
     * N and M, and when ever a 0 occurs update the ith position in one array and
     * jth position with -1 in another array.
     * - Whenever the -1 is found update the matrix[i][j] to 0
     * 
     * OPTIMAL APPROACH:
     * - A bit tricky
     * - First check if 0 is in 0th row and col, if yes keep track of them
     * - now check from 1st index of row and col and wherever matrix[i][j] = 0 then
     * matrix[i][0] = 0 and matrix[0][j] = 0
     * - traverse over the matrix once again from i = 1 and j = 1 and check if at
     * index matrix[i][0] == 0 or matrix[0][j] == 0 then mark matrix[i][j] = 0
     * - Now check there was any zero from the before altering the array (the one
     * you saved in point), if yes then update the matrix[i][0] = 0
     * - Follow the prev step with col also
     */

    public void setZeroes(int[][] matrix) {
        // BRUTE FORCE:

        // int[][] A = new int[matrix.length][matrix[0].length];

        // int N = matrix.length, M = matrix[0].length;

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < M; j++) {
        // if(matrix[i][j] == 0) {
        // for(int k = 0; k < N; k++) {
        // A[k][j] = -1;
        // }

        // for(int k = 0; k < M; k++) {
        // A[i][k] = -1;
        // }
        // }
        // }
        // }

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < M; j++) {
        // if(A[i][j] == -1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }

        // TC: O(N * M * (N + M)) -> O(N^3) SC: O(N * M)

        // ----------------------------------------------------------------

        // BETTER APPROACH:

        // int N = matrix.length;
        // int M = matrix[0].length;

        // int[] rows = new int[N];
        // int[] cols = new int[M];

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < M; j++) {
        // if(matrix[i][j] == 0) {
        // rows[i] = -1;
        // cols[j] = -1;
        // }
        // }
        // }

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < M; j++) {
        // if(rows[i] == -1 || cols[j] == -1) {
        // matrix[i][j] = 0;
        // }
        // }
        // }
        // TC: O(N * M) -> O(N ^ 2) SC: O(N + M)

        // OPTIMAL SOLUTION:

        int N = matrix.length;
        int M = matrix[0].length;

        boolean zeroInRow = false;
        boolean zeroInCol = false;

        for (int i = 0; i < N; i++) {
            if (matrix[i][0] == 0)
                zeroInRow = true;
        }

        for (int i = 0; i < M; i++) {
            if (matrix[0][i] == 0)
                zeroInCol = true;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroInRow) {
            for (int i = 0; i < N; i++) {
                matrix[i][0] = 0;
            }
        }

        if (zeroInCol) {
            for (int i = 0; i < M; i++) {
                matrix[0][i] = 0;
            }
        }

        // TC: O(N * M)
    }
}