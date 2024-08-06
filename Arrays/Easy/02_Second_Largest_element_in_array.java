// https://www.geeksforgeeks.org/problems/second-largest3735/1

import java.util.List;

class Solution {
    public int print2largest(List<Integer> arr) {
        // Code Here

        // Brute force:
        // Sort the array and return the last second element

        // Collections.sort(arr);
        // return arr.get(arr.size() - 2); // No need to check for ArrayIndexOutOfBound exception as list will contain min 2 elements

        // TC: O(NlogN)

        // -----------------------------------------------------

        // OPTIMIZED approach

        // - Keep 2 variables to track the first and second highest elements
        // - If a new element occurs which is greater than first largest update the
        // second largest and first largest values
        // - If a variable is less than first largest and great second largest, check
        // that the variable should not be equal to first largest

        int first = -1, second = -1;

        for (int i : arr) {
            if (first < i) {
                second = first;
                first = i;
            } else if (i != first && second < i) {
                second = i;
            }
        }

        return second;
        
        // TC: O(N)
    }
}