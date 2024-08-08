// https://leetcode.com/problems/sort-colors/submissions/898466309/

class Solution {
    public void sortColors(int[] nums) {

        // ----------------------- Brute force (Sorting) ----------------------

        // Arrays.sort(nums);

        // ----------------------- Better approach (Count sort) ---------------

        // int zero = 0, one = 0, two = 0;
        // for (int i : nums) {
        //     if (i == 0) {
        //         zero++;
        //     } else if (i == 1) {
        //         one++;
        //     } else {
        //         two++;
        //     }
        // }
        // int i = 0;
        // while (zero != 0) {
        //     nums[i++] = 0;
        //     zero--;
        // }
        // while (one != 0) {
        //     nums[i++] = 1;
        //     one--;
        // }
        // while (two != 0) {
        //     nums[i++] = 2;
        //     two--;
        // }

        // ----------------------- Optimal approach (Dutch national flag algo) -------------------------

        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, mid++, low++);
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high--); // we don't increment mid because updated value can be 0, so we check again
            }
        }
    }

    void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}