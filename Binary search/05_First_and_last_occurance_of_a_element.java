// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array

class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[] { search(nums, target, true), search(nums, target, false) };
    }

    public int search(int[] a, int x, boolean checkFirst) {
        int low = 0, high = a.length - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (a[mid] == x) {
                ans = mid;
                if (checkFirst) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}