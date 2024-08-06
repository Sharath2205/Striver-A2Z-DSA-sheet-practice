// https://leetcode.com/problems/rotate-array/description/

class Solution {

    /**
        BRUTE FORCE: 
        - For every element traverse it to end k times 

        OPTIMAL APPROACH: 
        - Assume array [1, 2, 3, 4, 5, 6, 7], k -> 3
        - output will be [5, 6, 7, 1, 2, 3, 4]

        - Rotate array from 0 to N - k
        - Array will be [4, 3, 2, 1, 5, 6, 7]

        - Rotate array from N - K + 1 to N - 1
        - Array will be [4, 3, 2, 1, 7, 6, 5]

        - Rotate the entire array 
        - Array will be [5, 6, 7, 1, 2, 3, 4]

     */

    public void rotate(int[] nums, int k) {

        // BRUTE FORCE:

        // while(k-- != 0) {
        //     int lastElement = nums[nums.length - 1];

        //     for(int i = nums.length - 1; i > 0; i--) {
        //         nums[i] = nums[i - 1];
        //     }

        //     nums[0] = lastElement;
        // }

        // TC: O(K * N)

        // ----------------------------------------------------

        // OPTIMAL APPROACH:  


        int N = nums.length;

        if(k > N) {         // If the rotation size is greater than N reduce the size to K
            k %= N;
        }  

        rotateArray(nums, 0, N - k - 1);
        rotateArray(nums, N - k, N - 1);
        rotateArray(nums, 0, N - 1);
    }

    private void rotateArray(int[] nums, int i, int j) {
        while(i <= j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++; j--;
        }
    }
}