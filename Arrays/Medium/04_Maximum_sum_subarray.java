// https://leetcode.com/problems/maximum-subarray/

class Solution {

    /**
     * BRUTE FORCE:
     * - Generate all possible subarrays and find there sum
     * - If the max is less than sum update the max to sum
     * 
     * BETTER APPROACH:
     * - We can eliminate the 3rd loop for traversing from i to j pointer
     * 
     * OPTIMAL:
     * - Kadane's algo
     * - Add the element to sum
     * - Update the max value if sum is greater than max
     * - If the sum less than 0 (negative value) make sum as 0 (We only need maximum
     * sum subarray)
     */

    public int maxSubArray(int[] nums) {

        // BRUTE FORCE:

        // int max = 0;

        // for(int i = 0; i < nums.length; i++) {
        // for(int j = i; j < nums.length; j++) {
        // int sum = 0;

        // for(int k = i; k <= j; k++) {
        // sum += nums[k];
        // }

        // if(sum > max) max = sum;
        // }
        // }

        // return max;

        // TC: O(N^3)

        // ------------------------------------------

        // BETTER APPROACH:

        // int max = 0;

        // for(int i = 0; i < nums.length; i++) {
        // int sum = 0;
        // for(int j = i; j < nums.length; j++) {
        // sum += nums[j];
        // if(sum > max) max = sum;
        // }

        // }

        // return max;

        // TC: O(N^2)

        // ---------------------------------------------------

        // OPTIMAL APPROACH: (KADANE's ALGORITHM)

        int max = Integer.MIN_VALUE, sum = 0;

        for (int i : nums) {
            sum += i;
            if (max < sum)
                max = sum;
            if (sum < 0)
                sum = 0;
        }

        return max;

        // TC: O(N)
    }
}