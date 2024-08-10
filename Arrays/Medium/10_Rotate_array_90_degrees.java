// https://leetcode.com/problems/rotate-image/description/

class Solution {

    /**
     * 
     * BRUTE FORCE:
     * - Take a new dummy matrix and traverse the given matrix.
     * - Put every row of given matrix as col in dummy matrix
     * EX: 1 2 3 - - 1
     * - - - - - 2
     * - - - - - 3
     * 
     * Means dummy[j][N - i - 1] = matrix[i][j]
     * 
     * BETTER APPROACH:
     * - First derive transpose of the matrix M -> M^T
     * - ex: 1 2 3 1 4 7
     * 4 5 6 -> 2 5 8
     * 7 8 9 3 6 9
     * 
     * swap(matrix[i][j], matrix[j][i])
     * 
     * - Now reverse the cols in the matrix
     * swap(matrix[i][j], matrix[i][N - j - 1])
     * 
     */

    public void rotate(int[][] matrix) {

        // BRUTE FORCE:

        // int N = matrix.length;

        // int[][] dummy = new int[N][N];

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < N; j++) {
        // dummy[j][N - i - 1] = matrix[i][j];
        // }
        // }

        // for(int i = 0; i < N; i++) {
        // for(int j = 0; j < N; j++) {
        // matrix[i][j] = dummy[i][j];
        // }
        // }

        // TC: O(N^2) SC:(N^2)

        // ------------------------------------------------------------------

        // BETTER APPROACH:

        int N = matrix.length;

        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N - j - 1];
                matrix[i][N - j - 1] = temp;
            }
        }

        // TC: O(N^2)

    }
}