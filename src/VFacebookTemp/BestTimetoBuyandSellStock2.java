package VFacebookTemp;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Iterator an algorithm to find the maximum profit. You may complete as many transactions as you like
 (ie, buy one and sell one share of the stock multiple times).
 However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */

public class BestTimetoBuyandSellStock2 {

    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i+1] - prices[i];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

    //If there is a transaction fee.
    //We can find all the increasing wave first, and count the profit
    public int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int min = prices[0], max = prices[0], rst = 0;
        for (int i = 1; i < prices.length; i++) {
            if (i == prices.length - 1) {
                max = Math.max(prices[i], max);
                rst += max - min;
                break;
            }
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] < max) {
                rst += max - min;
                max = min = prices[i];
            }
        }
        return rst;
    }

}
