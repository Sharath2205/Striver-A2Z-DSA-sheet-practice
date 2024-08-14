// https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1


class Solution {

    // Floor of an element X: Largest element K such that k <= x

    static int findFloor(long arr[], int n, long x) {
        int low = 0, high = n - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = mid; // possible answer as it is lower than x
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }
}
