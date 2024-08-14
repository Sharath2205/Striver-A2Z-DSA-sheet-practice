package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

class GfG {
    int maxLen(int arr[], int n) {

        // BRUTE FORCE:
        // int max = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i; j < n; j++) {
        //         long sum = 0;
        //         for (int k = i; k <= j; k++) {
        //             sum += arr[k];
        //         }
        //         if (sum == 0) {
        //             max = Math.max(max, j - i + 1);
        //         }
        //     }
        // }

        // return max;

        // TC: O(N^3)

        // -------------------------------

        // BETTER APPROACH:
        // int max = 0;

        // for (int i = 0; i < n; i++) {
        //     long sum = 0;
        //     for (int j = i; j < n; j++) {
        //         sum += arr[j];
        //         if (sum == 0) {
        //             max = Math.max(max, j - i + 1);
        //         }
        //     }
        // }

        // return max;

        // TC: O(N^2)

        // --------------------------

        // OPTIMAL APPROACH:

        Map<Long, Integer> map = new HashMap<>();

        long sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            if (sum == 0)
                max = i + 1;

            if (map.containsKey(sum)) {
                max = Math.max(max, i - map.get(sum));
            }
            if (!map.containsKey(sum))
                map.put(sum, i);
        }

        return max;

        // TC: O(N) SC:O(N)
    }
}