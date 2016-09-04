package DP.DP_interval;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most k transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */


public class BestTimetoBuyandSellStock4 {

    public int maxProfit(int k, int[] prices) {
        // write your code here
        if (k == 0 || prices==null || prices.length==0 ) {
            return 0;
        }

        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }

        int len = prices.length;
        int[][] mustsell = new int[k + 1][len + 1];
        // mustSell[i][j] 表示前i天，至多进行j次交易，第i天必须sell的最大获益
        int[][] globalbest = new int[k + 1][len + 1];
        // globalbest[i][j] 表示前i天，至多进行j次交易，第i天可以不sell的最大获益


        for (int i = 1; i <= k ; i++) {
            for (int j = 1; j < len; j++) {

                int diff = prices[j] - prices[j - 1];

                //sell as a new transaction or old transaction
                mustsell[i][j] = Math.max(globalbest[i - 1][j - 1] + diff,
                        mustsell[i][j-1] + diff);

                //update global i transaction if need to sell at time j
                globalbest[i][j] = Math.max(globalbest[i][j-1], mustsell[i][j]);
            }
        }
        return globalbest[k][len-1];
    }

}
