// https://leetcode.com/problems/merge-sorted-array/

package Arrays.Hard;

class Solution {

    /**
     * BRUTE FORCE:
     * - Add all elements into one array and sort them
     * - *Check out for edge cases
     * 
     * BETTER APPROACH:
     * - Make a new array and keep adding elements into it in ascending order
     * - Copy the elements into original array
     * 
     * OPTIMAL APPROACH:
     * - Iterate from end of the nums1 array
     * - Keep adding greater elements from end
     * 
     * 
     * or 
     * 
     * - using gap method
     */

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        // BRUTE FORCE:
        // if (m == 0 || n == 0)
        //     return;

        // int i = m;
        // while (m < nums1.length) {
        //     nums1[m] = nums2[m - n];
        //     m++;
        // }

        // Arrays.sort(nums1);

        // TC: O(NlogN)

        // BETTER APPROACH:
        // int[] nums = new int[m + n];
        // int i = 0, j = 0, k = 0;

        // while (i < m && j < n) {
        //     if (nums1[i] < nums2[j]) {
        //         nums[k++] = nums1[i++];
        //     } else {
        //         nums[k++] = nums2[j++];
        //     }
        // }

        // while (i < m) {
        //     nums[k++] = nums1[i++];
        // }

        // while (j < n) {
        //     nums[k++] = nums2[j++];
        // }

        // for (i = 0; i < nums.length; i++) {
        //     nums1[i] = nums[i];
        // }

        // TC: O(N) SC:O(N)

        // int i = m + n - 1;

        // while (m > 0 && n > 0) {
        //     if (nums1[m - 1] > nums2[n - 1]) {
        //         nums1[i--] = nums1[--m];
        //     } else {
        //         nums1[i--] = nums2[--n];
        //     }
        // }

        // while (m > 0) {
        //     nums1[i--] = nums1[--m];
        // }

        // while (n > 0) {
        //     nums1[i--] = nums2[--n];
        // }
        // TC: O(N) SC:O(1)

        // GAP METHOD (Shell sort):

        int len = m + n;
        int gap = (len / 2) + (len % 2);

        while (gap > 0) {
            int left = 0;
            int right = left + gap;
            while (right < len) {
                if (left < m && right >= m) {// if left is in nums1 and right is in nums2
                    swapIfGreater(nums1, nums2, left, right - m);
                } else if (left >= m) { // if left is in nums2 and right is in nums2
                    swapIfGreater(nums2, nums2, left - m, right - m);
                } else { // if left is in nums1 and right is in nums1
                    swapIfGreater(nums1, nums1, left, right);
                }
                left++;
                right++;
            }
            if (gap == 1)
                break;
            gap = (gap / 2) + (gap % 2);
        }

        for (int i = 0; i < n; i++) {
            nums1[i + m] = nums2[i];
        }

        // TC: O(N) SC: O(1)
    }

    private void swapIfGreater(int[] arr1, int[] arr2, int i, int j) {
        if (arr1[i] > arr2[j]) {
            int temp = arr1[i];
            arr1[i] = arr2[j];
            arr2[j] = temp;
        }
    }
}