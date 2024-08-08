// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashSet;
import java.util.Set;

class Solution {

    /**
     * BRUTE FORCE:
     * - For every element check if the next element is present in the array using
     * linear search
     * - If found increment the value and perfrom step one
     * - For every check keep incrementing an count variable to keep track of number
     * of elements in the sequence
     * - After every check keep updating the ans variable
     * 
     * BETTER APPROACH:
     * - Sort the array
     * - Check if the nums[i] + 1 == nums[i + 1], if yes increase the count
     * - else update the max count and reset the count
     * 
     * OPTIMAL APPROACH:
     * - Instead of linear search use sets to find the first index.
     * - Add all elements to the set
     * - traverse the set (assume i) and check if (i - 1) is present in set, if yes
     * ignore
     * - if not that is the starting number of subsequence, Keep looking for next
     * number and update the result variable accordingly
     */

    public int longestConsecutive(int[] nums) {

        // BRUTE FORCE:
        // int count = 0, ans = 0;
        // for(int i = 0; i < nums.length; i++) {
        // int presentVariable = nums[i];
        // count = 0;
        // while(linearSearch(nums, presentVariable)) {
        // presentVariable += 1;
        // count++;
        // }

        // ans = Math.max(ans, count);
        // }

        // return ans;

        // TC: O(N^2)

        // --------------------------------------

        // BETTER APPROACH:

        // if(nums.length == 0) return 0;

        // Arrays.sort(nums);

        // int ans = 0, count = 0, prev = Integer.MIN_VALUE;

        // for(int i = 0; i < nums.length; i++) {
        // if(nums[i] - 1 == prev) {
        // prev = nums[i];
        // count++;
        // } else if(nums[i] != prev) { // There can be duplicate so ignore those and
        // check if the next element is part of the sequence
        // prev = nums[i];
        // count = 1;
        // }
        // ans = Math.max(ans, count);
        // }

        // ans = Math.max(ans, count);

        // return ans;
        // TC: O(NlogN)

        // -------------------------------------------------

        // OPTIMAL APPROACH:
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        int ans = 0, count = 0;

        for (int i : nums)
            set.add(i);

        for (int i : set) {
            if (!set.contains(i - 1)) {
                count = 1;
                while (set.contains(i + 1)) {
                    count++;
                    i++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;

        // Time Complexity: O(N) + O(2*N) ~ O(3*N), where N = size of the array.
        // Reason: O(N) for putting all the elements into the set data structure. After
        // that for every starting element, we are finding the consecutive elements.
        // Though we are using nested loops, the set will be traversed at most twice in
        // the worst case. So, the time complexity is O(2*N) instead of O(N2).

    }

    @SuppressWarnings("unused")
    private boolean linearSearch(int[] arr, int x) {

        for (int i : arr) {
            if (i == x)
                return true;
        }

        return false;
    }
}