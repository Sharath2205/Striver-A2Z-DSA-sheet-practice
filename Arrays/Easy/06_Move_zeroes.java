// https://leetcode.com/problems/move-zeroes/

class Solution {

    /**
     * BRUTE FORCE:
     * - Take pointer and whenever a non zero number occurs insert it in the array
     * and update the pointer.
     * - Once the traversal is completed update the rest indices with 0
     */

    public void moveZeroes(int[] nums) {
        int idx = 0;

        for (int i : nums) {
            if (i != 0) { // When ever a non zero element is encountered put the value in idx position and
                          // increment idx
                nums[idx++] = i;
            }
        }

        while (idx < nums.length) {
            nums[idx++] = 0;
        }
    }
}