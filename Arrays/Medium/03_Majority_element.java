// https://leetcode.com/problems/majority-element/

class Solution {

    /**
     * BRUTE FORCE:
     * - Sort the array
     * - Return nums[N / 2] value
     * 
     * BETTER APPROACH:
     * - Keep a freq map
     * - Store value and its freq
     * - Check if the freq is greater than or equals N / 2, if yes return the value
     * 
     * OPTIMAL APPROACH:
     * - Take two variables candidate and count, which tracks array values and its
     * count
     * - When ever count is 0 update the candidate key with the next value in array
     * - If the i-th value == candidate increment the count else decrement
     */

    public int majorityElement(int[] nums) {
        // BRUTE FORCE:

        // Arrays.sort(nums);
        // return nums[nums.length / 2];

        // TC: O(NlogN)

        // -----------------------------

        // BETTER APPROACH:

        // Map<Integer, Integer> mp = new HashMap();

        // for(int i: nums) {
        // mp.put(i, mp.getOrDefault(i, 0) + 1);

        // if(mp.get(i) > nums.length / 2) return i;
        // }

        // return -1;

        // TC: O(N) SC: O(N)

        // -----------------------------------------

        // OPTIMAL APPROACH:

        // Candidate key - Keeps track of the largest element in the array

        int candidate = 0, count = 0;

        for (int i : nums) {
            if (count == 0) {
                candidate = i;
            }

            if (i == candidate) {
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}