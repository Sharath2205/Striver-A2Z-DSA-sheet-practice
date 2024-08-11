// https://leetcode.com/problems/merge-intervals/?source=submission-noac

package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] I) {
        Arrays.sort(I, (a, b) -> a[0] - b[0]);

        List<int[]> list = new ArrayList<>();

        list.add(I[0]);

        for (int i = 1; i < I.length; i++) {
            int[] prev = list.get(list.size() - 1);
            int[] curr = I[i];
            if (prev[1] < curr[0]) {
                list.add(curr);
            } else {
                prev[1] = Math.max(prev[1], curr[1]); // Check if the present end
            }
        }

        return list.toArray(new int[list.size() - 1][]);

    }
}