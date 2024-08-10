// https://leetcode.com/problems/3sum/

package Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    /**
     * BRUTE FORCE:
     * - Take 3 loops i: 0 -> N - 2, j: i + 1 -> N - 1, k: j + 1: N such that all
     * are pointing towards different elements
     * - Added 3 elements nums[i], nums[j], nums[k], If the sum is 0 add it to array
     * list
     * - Before adding check whether the list with same elements is already present
     * in the list
     * - If yes don't add it.
     * 
     * BETTER APPROACH:
     * - Instead of using 3 loops try to complete with 2 loops.
     * - for the third element, the value should be -(nums[i] + nums[j]);
     * - Proof: nums[i] + nums[j] + nums[k] = 0 => nums[i] + nums[j] = -nums[k]
     * multipling by - on both sides -(nums[i] + nums[j]) = nums[k]
     * - Take another Set<int> to keep track of all j elements and check if
     * -(nums[i] + nums[j]) exists in the set
     * - If yes add sort it and add it into the set<list<int>>. Sort it to avoid
     * duplicates in the list
     * 
     * OPTIMAL APPROACH:
     * - Sort the nums array.
     * - Run a for loop from i: 0 -> N - 2
     * - Proceed if i == 0 || nums[i] != nums[i - 1] to avoid duplicates
     * - Follow two pointer approach by adding when sum of i, low, high elements is
     * 0 and low++, high--
     * - and increase low if the sum < 0, decrease high sum > 0
     * - EDGE CASE: after adding triplet into ans list run a while loop on low and
     * high such that they are pointing towards different number than previous one
     * - nums[low] != nums[low - 1] and also with high nums[high] != nums[high + 1]
     */

    public List<List<Integer>> threeSum(int[] nums) {
        // BRUTE FORCE:
        // List<List<Integer>> ans = new ArrayList<>();

        // for(int i = 0; i < nums.length - 2; i++) {
        // for(int j = i + 1; j < nums.length - 1; j++) {
        // int rem = nums[i] + nums[j];
        // for(int k = j + 1; k < nums.length; k++) {
        // if(nums[k] * -1 == rem) {
        // List<Integer> triplet = List.of(nums[i], nums[j], nums[k]);
        // if(!contains(ans, triplet)) ans.add(triplet);
        // }
        // }
        // }
        // }

        // return ans;

        // TC: O(N^3) SC: O(1)

        // ----------------------------------------

        // BETTER APPROACH:

        // Set<List<Integer>> set = new HashSet<>();

        // for(int i = 0; i < nums.length; i++) {
        // Set<Integer> elementsStore = new HashSet<>();
        // for(int j = i + 1; j < nums.length; j++) {
        // int rem = -(nums[i] + nums[j]);
        // if(elementsStore.contains(rem)) {
        // List<Integer> triplet = Arrays.asList(nums[i], nums[j], rem);
        // triplet.sort(null); // provide compartor as null
        // set.add(triplet);
        // }
        // elementsStore.add(nums[j]);
        // }
        // }

        // List<List<Integer>> result = new ArrayList<>(set);

        // return result;

        // TC: O(N^2) * O(log(no.of unique triplets)) -> O(log(unique triplets)) is for
        // inserting into set
        // Overall TC: O(N^2) SC: O(no.of unique triplets) * O(N) -> O(N) for extra set

        // -------------------------------------

        // OPTIMAL APPROACH:

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    int sum = nums[i] + nums[low] + nums[high];
                    if (sum == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[low], nums[high]);
                        result.add(triplet);
                        low++;
                        high--;
                        while (low < high && nums[low] == nums[low - 1])
                            low++;
                        while (low < high && nums[high] == nums[high + 1])
                            high--;
                    } else if (sum > 0) {
                        high--;
                    } else {
                        low++;
                    }
                }
            }
        }

        return result;
    }

    @SuppressWarnings("unused")
    private boolean contains(List<List<Integer>> list, List<Integer> triplet) {
        for (List<Integer> i : list) {
            if (i.containsAll(triplet) && triplet.containsAll(i))
                return true;
        }
        return false;
    }
}