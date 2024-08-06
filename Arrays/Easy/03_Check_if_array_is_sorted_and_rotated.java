// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

/**
 * 
 * Brute force:
 * - Check the array from 0 to (N - 1)th element and increase the count if
 * nums[i] > nums[i + 1]
 * - We also have to check for the last element so check if the last element is
 * greater than first and if yes increase the count
 * - If the count > 1 then the array is not sorted and rotated once.
 * 
 * // ENHANCEMENT-
 * // - We dont need to check for the last element again as the last element
 * will be auto check for the condition nums[i] > nums[(i + 1) nums.length]
 * // ex: [1, 2, 3, 4, 5] -> nums[4] > nums[(4 + 1) % 5]
 * // -> nums[4] > nums[5 % 5] -> 5 % 5 is 0
 */

class Solution {
    public boolean check(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length])
                count++;
        }

        return count < 2;
    }
}