// https://leetcode.com/problems/majority-element-ii/

package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

class Solution {

    /**
     * - Problem states to find all elements which appears more than floor of N / 3.
     * 
     * BRUTE FORCE:
     * - Find floor of array size / 3;
     * - Run to loops and find all the elements appearing more than N times in the
     * array.
     * 
     * BETTER APPROACH:
     * - Use a hashmap to keep the freq of the variables
     * - If any varibale count is greater than floor add it to ans
     * 
     * OPTIMAL APPROACH:
     * - Refer to striver for better explaination
     */
    public List<Integer> majorityElement(int[] nums) {
        // BRUTE FORCE:

        // Set<Integer> set = new HashSet<>();
        // int count;

        // int floor = nums.length / 3;

        // for(int i = 0; i < nums.length; i++) {
        // count = 0;

        // for(int j = i; j < nums.length; j++) {
        // if(nums[i] == nums[j]) {
        // count++;
        // }
        // }
        // if(count > floor) {
        // set.add(nums[i]);
        // }
        // }

        // return new ArrayList<>(set);

        // TC: O(N^2)

        // --------------------------------------------------

        // BETTER APPROACH:

        // int floor = nums.length / 3;

        // Map<Integer, Integer> mp = new HashMap<>();
        // List<Integer> ans = new ArrayList<>();

        // for(int i: nums) {
        // mp.put(i, mp.getOrDefault(i, 0) + 1);
        // }

        // for(Map.Entry<Integer, Integer> entry: mp.entrySet()) {
        // if(entry.getValue() > floor) ans.add(entry.getKey());
        // }

        // return ans;

        // TC: O(N) SC:O(N)

        // -------------------------------------------------

        // OPTIMAL APPROACH:

        int floor = nums.length / 3;

        int majority1 = -1, majority2 = -1, count1 = 0, count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            int element = nums[i];

            if (majority1 == element) {
                count1++;
            } else if (majority2 == element) {
                count2++;
            } else if (count1 == 0) {
                majority1 = element;
                count1++;
            } else if (count2 == 0) {
                majority2 = element;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        count1 = 0;
        count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majority1)
                count1++;
            else if (nums[i] == majority2)
                count2++;
        }

        List<Integer> ans = new ArrayList<>();

        if (count1 > floor)
            ans.add(majority1);
        if (count2 > floor)
            ans.add(majority2);

        return ans;
    }
}