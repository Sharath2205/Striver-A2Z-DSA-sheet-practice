// https://leetcode.com/problems/single-number/submissions/1346849633/

class Solution {

    /**
     * 
     * Brute force:
     * - Sort the array
     * - check if nums[i] == nums[i + 1] and increment the i by +2
     * - If the condition fails return nums[i] as it has occured only once
     * 
     * Better approach:
     * - Take a set or map to keep the frequency count
     * - Return the element that contains only once
     * 
     * Optimized:
     * - XoR of any number to itself is 0. Ex: 5^5 = 0 8^8 = 0
     * - Find out the xor of all the elements in the array.
     * - The value of the xor will be the unique element in the array
     * 
     */

    public int singleNumber(int[] nums) {

        // BRUTE FORCE:
        // Arrays.sort(nums);

        // for(int i = 0; i < nums.length - 1; i += 2) {
        // if(nums[i] != nums[i + 1]) return nums[i];
        // }

        // return nums[nums.length - 1];

        // TC: O(NlogN)

        // ---------------------------------------------

        // Better approach:

        // Set<Integer> set = new HashSet();

        // for(int i: nums) {
        // if(set.contains(i)) {
        // set.remove(i);
        // }else {
        // set.add(i);
        // }
        // }

        // return set.iterator().next();

        // TC: O(N) SC: O(N)

        // ---------------------------------------------

        int xor = 0;

        for (int i : nums) {
            xor ^= i;
        }

        return xor;
        // TC: O(N)
    }
}