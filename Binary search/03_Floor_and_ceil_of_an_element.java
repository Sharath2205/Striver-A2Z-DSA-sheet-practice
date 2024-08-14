import java.util.Arrays;

class Solution {
    public int[] getFloorAndCeil(int x, int[] arr) {
        // code here
        Arrays.sort(arr);

        return new int[] { floor(x, arr), ceil(x, arr) };
    }

    public int floor(int x, int[] arr) {
        int low = 0, high = arr.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] <= x) {
                ans = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    public int ceil(int x, int[] arr) {
        int low = 0, high = arr.length - 1;

        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] < x) {
                low = mid + 1;
            } else {
                ans = arr[mid];
                high = mid - 1;
            }
        }

        return ans;
    }
}
