// https://leetcode.com/problems/missing-number/description/

import java.util.Arrays;

class Solution {

    /**
     * BRUTE FORCE:
     * - Sort the array
     * - Run a for loop from 0 -> N, if at any point i != nums[i] then that number
     * is missing
     * - If the for loops run and exits without return then N-th element is missing
     * 
     * - OPTIMAL APPROACH:
     * - Sum of N natural numbers = N * (N + 1) / 2;
     * - If we want to find out 1 missing number in N natural numbers we can simply
     * do sum of N natural numbers - sum of given numbers
     */

    public int missingNumber(int[] nums) {

        // BRUTE FORCE:

        // Arrays.sort(nums);
        // int i = 0;
        // for (; i < nums.length; i++) {
        // if (nums[i] != i)
        // return i;
        // }
        // return i;

        // TC: O(NlogN)

        // ------------------------------

        int n = nums.length;

        int sumOfN = n * (n + 1) / 2; // Sum of N numbers

        int sum = Arrays.stream(nums).sum(); // Sum of all elements in the array

        return sumOfN - sum; // Return the missing number in the array

        // TC: O(N)
    }
}