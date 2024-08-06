// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {

    /**
     * Brute force:
     * 
     * - Create a new N size array and add the non duplicate elements
     * - Update the same to the original array
     * - Return the length of the elements in the new array
     * 
     * 
     * Optimal approach:
     * 
     * - Just keep updating the original array.
     * - If the element at idx and i-th index is same then dont update the value.
     * - If the element at idx and i-th index is diff then update the value and
     * update the idx pointer
     */

    public int removeDuplicates(int[] nums) {
        // int[] uniqueElements = new int[nums.length];

        // int idx = 0; // store the index out side to utilise it again

        // for(int i = 0; i < nums.length; i++) {
        // if(i == 0 || uniqueElements[idx - 1] != nums[i]) { // Push the elements if it
        // is a first element or if element in i-th index is not present in unique
        // elements array
        // uniqueElements[idx++] = nums[i];
        // }
        // }

        // for(int i = 0; i < idx; i++) {
        // nums[i] = uniqueElements[i]; // Transfering elements into original array
        // }

        // return idx;

        // TC: O(N) SC: O(N)

        // ---------------------------------------------------------

        // Optimal approach:

        int idx = 1; // As the first element will be same start from second element i.e: idx = 1

        for (int i = 1; i < nums.length; i++) {
            // check if the prev unique value is different from i-th value
            // if value as new unique value and update the unique pointer i.e: idx++
            if (nums[idx - 1] != nums[i]) {
                nums[idx++] = nums[i];
            }
        }

        return idx;
    }
}