// https://leetcode.com/problems/rearrange-array-elements-by-sign/

class Solution {

    /**
     * BRUTE FORCE:
     * - Take a new array of size N
     * - Take pos = 0 and neg = 1 as we have store pos elements in even index and neg in odd index
     * - Traverse all elements in the nums array check if the number is pos or neg
     * - If pos insert the element at newArr[pos] and increase the pos by 2
     * - If neg insert the element at newArr[neg] and increase the neg by 2
     * 
     */

    public int[] rearrangeArray(int[] nums) {
        int N = nums.length;
        int[] ans = new int[N];
        int pos = 0, neg = 1;

        for (int i = 0; i < N; i++) {
            if (nums[i] > 0) {
                ans[pos] = nums[i];
                pos += 2;
            } else {
                ans[neg] = nums[i];
                neg += 2;
            }
        }

        return ans;

        // TC: O(N) SC: O(N)
    }
}