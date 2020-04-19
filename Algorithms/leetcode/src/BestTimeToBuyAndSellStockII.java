// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {

        /*
        // Peak Valley Approach
        // Time complexity: O(n). Single pass
        // Space complexity O(1). Constant space required
        int totalProfit = 0, valley = prices[0], peak = prices[0];
        for (int i = 1; i < prices.length; ) {
            while (i < prices.length && prices[i - 1] >= prices[i]) i++;
            valley = prices[i];
            while (i < prices.length && prices[i - 1] <= prices[i]) i++;
            peak = prices[i];
            totalProfit += peak - valley;
        }
        return totalProfit;
         */

        // Simple One Pass
        // Time complexity: O(n). Single pass
        // Space complexity O(1). Constant space required
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxProfit += prices[i] - prices[i - 1];
        }
        return maxProfit;
    }
}
