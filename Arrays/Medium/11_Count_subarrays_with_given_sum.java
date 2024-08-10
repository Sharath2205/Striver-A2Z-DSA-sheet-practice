// https://leetcode.com/problems/subarray-sum-equals-k/

import java.util.HashMap;
import java.util.Map;

class Solution {

    /**
     * 
     * BRUTE FORCE:
     * - Generate all possible subarrays
     * - For each array check if the subarray sum equals K
     * - For more brute force way use 3 loops, 3rd loop to find sum of subarray but
     * I'm using 2 loops
     * 
     * OPTIMAL APPROACH:
     * - Take map to store the prefix sum and its freq, and a count variable to
     * store o/p
     * - Set value of 0 as 1 in map (Resolves the case where sum == k)
     * - Traverse the map and for every iteration add nums[i] to sum
     * - Check if the sum - k is present in the map, if yes add the count to count
     * variable
     * - Put the sum into map by incrementing its freq (If the value is inserted for
     * first time put freq as 1)
     * 
     */

    public int subarraySum(int[] nums, int k) {
        // int count = 0;
        // int N = nums.length;

        // for(int i = 0; i < N; i++) {
        // long sum = 0;
        // for(int j = i; j < N; j++) {
        // sum += nums[j];
        // if(sum == (long)k) {
        // count++;
        // }
        // }
        // }

        // return count;

        // TC: O(N^2)

        int N = nums.length;
        Map<Long, Integer> mp = new HashMap<>();

        mp.put(0L, 1); // must add as ex: 3-3 sum will be 0 so it has accrued at least once

        int count = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += nums[i];

            if (mp.containsKey(sum - k)) {
                count += mp.get(sum - k);
            }

            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }

        return count;

        // TC: O(N) SC: O(N)
    }
}