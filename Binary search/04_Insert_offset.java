class Solution {

    // Given a sorted array of distinct integers and a target value,return the index
    // if the target is found. If not,return the index where it would be if it were
    // inserted in order.
    // You must write an algorithm with O(log n) runtime complexity.

    // Example 1:

    // Input: nums = [1,3,5,6], target = 5
    // Output: 2
    // Example 2:

    // Input: nums = [1,3,5,6], target = 2
    // Output: 1
    // Example 3:

    // Input: nums = [1,3,5,6], target = 7
    // Output: 4

    /**
        BRUTE FORCE:
        - Traverse linearly over nums
        - Check for the first index such that nums[i] >= target, store the index value and break

        OPTIMAL SOLUTION:
        - Binary search
        - We have to check for an index where nums[mid] >= target
        - Whenever nums[mid] >= target store the mid value and decrement the high to check for other possible index
     */

    public int searchInsert(int[] nums, int target) {

        // BRUTE FORCE:
        // int ans = nums.length;
        
        // for(int i = 0; i < nums.length; i++) {
        //     if(nums[i] >= target) {
        //         ans = i;
        //         break;
        //     }
        // }

        // return ans;
        // TC: O(N)

        // ------------------------------

        // OPTIMAL APPROACH
        int low = 0, high = nums.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] >= target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

        // TC: O(logN)
    }
}