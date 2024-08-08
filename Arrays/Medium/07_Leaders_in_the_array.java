// https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

import java.util.ArrayList;
import java.util.Collections;

class Solution {
    
    /**
     * 
     * BRUTE FORCE:
     * - For every element in the array check if the right side have any number that is greater than present
     * - If no then add the element to the ans list
     * - EDGE CASE: last element will not be added to the array so directly add the element after the loop as there will be any element to the right which is greater than arr[n - 1] element
     * 
     * OPTIMAL SOLUTION:
     * - Traverse for last and keep track of a max variable
     * - Check if the element is greater than max variable
     * - If yes then update the max variable and add it to the list
     * - But the answer list will in reverse (as we traverse from end), so reverse list before returning
     */
    
    static ArrayList<Integer> leaders(int n, int arr[]) {
        
        // BRUTE FORCE: 
        
        // ArrayList<Integer> ans = new ArrayList<>();
        
        // for(int i = 0; i < n - 1; i++) {
        //     boolean isMax = true;
        //     for(int j = i + 1; j < n; j++) {
        //         if(arr[j] > arr[i]) {
        //             isMax = false;
        //         }
        //     }
            
        //     if(isMax) ans.add(arr[i]);
        // }
        
        // ans.add(arr[n - 1]);
        
        // return ans;
        
        // TC: O(N^2) SC: O(1)
        
        // Optimal
        int maxRight = -1;
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        for(int i = n - 1; i >= 0; i--) {
            if(arr[i] >= maxRight) {
                maxRight = arr[i];
                ans.add(arr[i]);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
        
        // TC: O(N) SC: O(1) // ignore the answer list 
    }
}
