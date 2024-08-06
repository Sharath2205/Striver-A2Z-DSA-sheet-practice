// https://www.geeksforgeeks.org/problems/who-will-win-1587115621/1

class Solution {

    /**
     * BRUTE FORCE:
     * - Traverse the array and when ever the element is encountered return the 1
     */

    static int searchInSorted(int arr[], int N, int K) {

        for (int i = 0; i < N; i++) {
            if (arr[i] == K)
                return 1;
        }

        return -1;
    }
}