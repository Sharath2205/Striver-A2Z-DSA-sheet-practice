// https://leetcode.com/problems/two-sum/

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * BRUTE FORCE:
     * - For every element check if there is any other element whose sum will be
     * equals to target
     * - If found return the indices of the elements
     * - If not return a default return
     * 
     * 
     * OPTIMAL APPROACH:
     * - Take a map which stores array values and corresponding indices
     * - For every i-th value before adding it to the map check if target - value is
     * present in the map
     * - If yes then the i-th value + (target - i-th value) which is in the map will
     * sum up to target
     * - Return the i-th index and target-value index
     * 
     */

    public int[] twoSum(int[] nums, int target) {

        // BRUTE FORCE:

        // for(int i = 0; i < nums.length - 1; i++) {
        // for(int j = i + 1; j < nums.length; j++) {
        // if(nums[i] + nums[j] == target) {
        // return new int[]{i, j};
        // }
        // }
        // }
        // return new int[]{-1, -1};

        // TC: O(N^2)

        // ---------------------------------------------

        // OPTIMAL APPROACH:

        Map<Integer, Integer> mp = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (mp.containsKey(target - nums[i])) {
                return new int[] { mp.get(target - nums[i]), i };
            } else {
                mp.put(nums[i], i);
            }
        }

        return new int[] { -1, -1 };

        // TC: O(N) SC: O(N)
    }
}