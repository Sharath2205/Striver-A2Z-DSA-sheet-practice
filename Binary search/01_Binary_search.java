// https://leetcode.com/problems/binary-search/

class Solution {
    public int search(int[] nums, int target) {

        // LINEAR SEARCH:
        // for(int i = 0; i < nums.length; i++) {
        // if(nums[i] == target) return i;
        // }

        // return -1;

        // TC: O(N)
        // ----------------------------------------

        // BINARY SEARCH:

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

        // TC: O(logN)
    }
}