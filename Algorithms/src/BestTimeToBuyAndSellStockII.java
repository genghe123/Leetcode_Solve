// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
        int totalProfit = 0, valley = prices[0], peak = prices[0];
        for (int i = 1; i < prices.length; ) {
            while (i < prices.length && prices[i - 1] >= prices[i]) i++;

        }
    }
}
