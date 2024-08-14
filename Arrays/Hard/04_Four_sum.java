// https://leetcode.com/problems/4sum/

package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // BRUTE FORCE:

        // Set<List<Integer>> set = new HashSet();

        // int N = nums.length;
        // for (int i = 0; i < N; i++) {
        // for (int j = i + 1; j < N; j++) {
        // int first2 = nums[i] + nums[j];
        // int rem = target - first2;
        // for (int k = j + 1; k < N; k++) {
        // for (int l = k + 1; l < N; l++) {
        // int second2 = nums[k] + nums[l];
        // if (rem == second2) {
        // List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
        // quadruplet.sort(null);
        // set.add(quadruplet);
        // }
        // }
        // }
        // }
        // }

        // return new ArrayList<List<Integer>>(set);

        // TC: O(N^4) SC:O(2 * no.of unique quadrulets) // set and list

        // -----------------------------------------------

        // BETTER APPROACH:
        // Set<List<Integer>> set = new HashSet<>();

        // int N = nums.length;

        // for (int i = 0; i < N; i++) {
        // for (int j = i + 1; j < N; j++) {
        // long first2 = nums[i] + nums[j];
        // long rem = target - first2;
        // Set<Long> find4th = new HashSet();
        // for (int k = j + 1; k < N; k++) {
        // long fourth = rem - nums[k];
        // if (find4th.contains(fourth)) {
        // List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[k],
        // (int) fourth);
        // quadruplet.sort(null);
        // set.add(quadruplet);
        // }
        // find4th.add((long) nums[k]);
        // }
        // }
        // }

        // return new ArrayList<List<Integer>>(set);

        // TC: O(N^3) SC:O(2 * no.of unique quadrulets) // set and list

        // OPTIMAL APPROACH:
        int N = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < N; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int low = j + 1, high = N - 1;

                while (low < high) {
                    long sum = nums[i];
                    sum += nums[j];
                    sum += nums[low];
                    sum += nums[high];
                    if (sum == target) {
                        List<Integer> quadruplet = Arrays.asList(nums[i], nums[j], nums[low], nums[high]);
                        result.add(quadruplet);
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1])
                            low++;
                        while (low < high && nums[high] == nums[high + 1])
                            high--;
                    } else if (sum > target) {
                        high--;
                    } else {
                        low++;
                    }

                }
            }
        }

        return result;

        // TC: O(N^3) SC: O(no.of unique quadruplets)
    }
}