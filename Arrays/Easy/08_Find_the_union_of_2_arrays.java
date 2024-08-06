
// https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

import java.util.ArrayList;
// import java.util.Set;
// import java.util.TreeSet;

class Solution {

    /**
     * BRUTE FORCE:
     * - When ever unique elements with order occurs think about we can TreeSet DS
     * - Add all the elements from arr1 and arr2 into treeset
     * - Return all the elements in treeset as an arraylist
     * 
     * 
     * OPTIMISED:
     * - Take 2 pointers i and j which traverses arr1 and arr2 respectively
     * - While condition i <= n && j <= m is true check if arr1[i] < arr2[j]
     * - If the above condition is true add arr1[i] else arr2[j]
     * - before adding them check the last element in the ans array, if they are
     * equal then skip that element
     * - Once the while condition breaks add the remaining elements from arr1 and
     * arr2 arrays into ans array
     * - Before adding check the last element again, if it's same skip the element
     */

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m) {
        // BRUTE FORCE:

        // Set<Integer> set = new TreeSet<>();

        // for(int i = 0; i < n; i++) {
        // set.add(arr1[i]);
        // }

        // for(int i = 0; i < m; i++) {
        // set.add(arr2[i]);
        // }

        // return new ArrayList<>(set);

        // TC: O(N) SC: O(N)

        // -----------------------------------------------

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                if (isLastDigit(ans, arr1[i]))
                    ans.add(arr1[i]);
                i++;
            } else {
                if (isLastDigit(ans, arr2[j]))
                    ans.add(arr2[j]);
                j++;
            }
        }

        while (i < n) {
            if (isLastDigit(ans, arr1[i])) {
                ans.add(arr1[i]);
            }
            i++;
        }

        while (j < m) {
            if (isLastDigit(ans, arr2[j])) {
                ans.add(arr2[j]);
            }
            j++;
        }

        return ans;

        // TC: O(N) SC: O(1)
    }

    private static boolean isLastDigit(ArrayList<Integer> arr, int x) {
        return arr.size() == 0 || arr.get(arr.size() - 1) != x;
    }
}
