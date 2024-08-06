// https://www.geeksforgeeks.org/problems/largest-element-in-array4009/0

class Solution {
    public static int largest(int n, int[] arr) {
        // code here

        // Brute force:

        // For every element check if it is the largest element

        // int ans = 0;

        // for(int i = 0; i < n; i++) {
        // boolean isGreatest = true;

        // for(int j = 0; j < n; j++) {
        // if(arr[j] > arr[i]) {
        // isGreatest = false;
        // }
        // }

        // if(isGreatest) ans = arr[i];
        // }

        // return ans;

        // TC: O(N^2)

        // -----------------------------------------------

        // Better approach:

        // Sort the array. Last element will the greatest element

        // Arrays.sort(arr);
        // return arr[arr.length - 1]; // No need to check for base condition as there
        // will be atleast one element in the array

        // TC: O(NlogN)

        // --------------------------------------------------

        // Optimal approach:

        // Perform a linear search
        // Keep an ans variable which holds the max value that occurs.
        // If a new max value is encountered update the ans value

        int ans = -1; // input range is from 0 <= arr[i] <= 10^5

        for (int i : arr) {
            ans = Math.max(ans, i);
        }

        return ans;
    }
}
