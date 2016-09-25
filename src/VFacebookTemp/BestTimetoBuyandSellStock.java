package VFacebookTemp;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 */
public class BestTimetoBuyandSellStock {

    public int maxProfit(int[] prices) {
        if(prices.length==0 || prices.length==1){
            return 0;
        }

        int profit = 0;
        int min = prices[0];

        for(int i=0;i<prices.length;i++){

            //a local min so far
            min = Math.min(min,prices[i]);

            //a global profit in general
            profit = Math.max(prices[i]-min,profit);
        }
        return profit;
    }
}
