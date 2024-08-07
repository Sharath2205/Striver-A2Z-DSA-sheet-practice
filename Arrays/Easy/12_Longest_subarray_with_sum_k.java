// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1

class Solution {

    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Complete the function

        // int max = 0;

        // for(int i = 0; i < N; i++) {
        // int sum = 0;
        // for(int j = i; j < N; j++) {
        // sum += A[j];

        // if(sum == K) {
        // max = Math.max(max, j - i + 1);
        // }
        // }
        // }
        // return max;

        // TC: O(N^2)

        // -------------------------------------------------

        // Map<Integer, Integer> map = new HashMap();

        // map.put(0, -1);

        // int sum = 0, max = 0;

        // for(int i = 0; i < N; i++) {
        // sum += A[i];

        // if(sum == K) max = i + 1;

        // if(map.containsKey(sum - K)) {
        // max = Math.max(max, i - map.get(sum - K));
        // }
        // if(!map.containsKey(sum)) map.put(sum, i);
        // }

        // return max;

        // TC: O(N) SC: O(N)

        // ---------------------------------------------------

        int left = 0, right = 0;

        int maxLen = 0, sum = 0;

        while (right < N) {
            sum += A[right];

            while (left <= right && sum > K)
                sum -= A[left++];

            if (sum == K)
                maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }
        return maxLen;

    }
}
