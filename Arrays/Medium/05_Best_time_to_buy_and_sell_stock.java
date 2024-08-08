// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

class Solution {

    /**
     * BRUTE FORCE:
     * - If buying on i-th index price check whats the profit for futures days j
     * - prices[j] - prices[i] gives profit/loss for buying a stock on i-th price
     * and selling it on j-th price
     * - If the profit is more than max update the max
     * 
     * OPTIMAL APPROACH:
     * - If todays price is low update the minPrice
     * - Check if todays prices - minPrice yeilds max profit, if yes update the max
     * profit
     */

    public int maxProfit(int[] prices) {
        // int max = 0;

        // for(int i = 0; i < prices.length - 1; i++) {
        // for(int j = i + 1; j < prices.length; j++) {
        // if(prices[j] - prices[i] > max) max = prices[j] - prices[i];
        // }
        // }

        // return max;

        // TC: O(N^2)

        int max = 0;
        int minPrice = prices[0];

        for (int i : prices) {
            if (minPrice > i)
                minPrice = i;
            else
                max = Math.max(max, i - minPrice);
        }

        return max;

        // TC: O(N)
    }
}