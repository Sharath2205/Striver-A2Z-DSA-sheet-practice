// https://leetcode.com/problems/spiral-matrix/

import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();

        int N = mat.length;
        int M = mat[0].length;

        int left = 0, right = M - 1, top = 0, bottom = N - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(mat[top][i]);
            }

            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(mat[i][right]);
            }

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }

            if (right >= left) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(mat[i][left]);
                }
                left++;
            }
        }

        return ans;
    }
}