// https://leetcode.com/problems/pascals-triangle/

package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        // Curr will store the present row values
        // Using prev we can derive curr elements
        List<Integer> curr, prev = null;

        for (int i = 1; i <= numRows; i++) {
            curr = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                // For the curr list the last elements will be 1 so directly add 1
                if (j == 0 || j == i - 1) {
                    curr.add(1);
                } else {
                    // curr[i] = prev[i] + prev[i - 1]
                    curr.add(prev.get(j) + prev.get(j - 1));
                }
            }

            // Add curr to ans list and update the prev with curr for next iteration
            ans.add(curr);
            prev = curr;
        }

        return ans;
    }
}