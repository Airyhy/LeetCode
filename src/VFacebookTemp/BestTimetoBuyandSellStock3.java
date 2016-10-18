package VFacebookTemp;

/**
 *
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Iterator an algorithm to find the maximum profit. You may complete at most two transactions.

 Note:
 You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 */
public class BestTimetoBuyandSellStock3 {

    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        int min = prices[0];
        for(int i=1;i<prices.length;i++){
            left[i] = Math.max(prices[i]-min,left[i-1]);
            min = Math.min(min,prices[i]);
        }

        int max = prices[prices.length-1];
        for(int i=prices.length-2;i>=0;i--){
            right[i] = Math.max(max-prices[i],right[i+1]);
            max = Math.max(max,prices[i]);
        }

        int profit = 0;
        for(int i=0;i<prices.length;i++){
            profit = Math.max(left[i]+right[i],profit);
        }
        return profit;
    }

}
