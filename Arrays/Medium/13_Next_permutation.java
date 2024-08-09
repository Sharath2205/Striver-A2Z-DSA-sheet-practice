// https://leetcode.com/problems/next-permutation/description/

class Solution {

    /**
     * 
     * BRUTE FORCE:
     * - Find all permutations of the given array in sorted order.
     * - Find index of nums in the permutations.
     * - Answer will be the next permutation.
     * - TC: O(N!) -> To find all permutations
     * 
     * OPTIMAL APPROACH:
     * - Traverse from reverse and find an index idx such that nums[idx] < nums[idx + 1]
     * - if idx == -1 then the array is the last permutation so return the reverse of nums
     * - else from right find a element such that nums[idx] < nums[i] // i traverses from last
     * - swap nums[i] and nums[idx]
     * - reverse the arary from idx + 1 to N
     * 
     */

    public void nextPermutation(int[] nums) {

        int idx = -1;

        // STEP 1: Find idx such that nums[i] < nums[i + 1]
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }

        // STEP 2: If the idx = -1 then reverse the array and return
        if (idx == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // STEP 3: Find an element from last such that nums[i] > nums[idx] and swap them
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[idx]) {
                swap(nums, i, idx);
                break;
            }
        }

        // STEP 4: Reverse the array from idx + 1 to N
        reverse(nums, idx + 1, nums.length - 1);

        // TC: O(N)
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}