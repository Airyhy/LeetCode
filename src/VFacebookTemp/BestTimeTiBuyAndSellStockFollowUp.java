package VFacebookTemp;

/**
 * Created by Christina on 2/29/16.
 */
public class BestTimeTiBuyAndSellStockFollowUp {
    /**
     * choices:买多股，全卖出，不买不卖
     *
     * iterate from the end to the start
     * add the max - current price into the result
     * if meet one that is larger than the max, update the max
     *
     */

    public int getMaxProfit(int nums[]) {
        if (nums == null || nums.length == 0) {return 0;}
        int max = nums[nums.length - 1];
        int ret = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            max = Math.max(max, nums[i]);
            ret += max - nums[i];
        }
        return ret;
    }

    /**
     * the same tansaction fee
     */

    public int getMaxProfit1(int prices[], int transFee) {
        if (prices.length < 2) {return 0;}
        int min = prices[0], max = prices[0], rst = 0;
        for (int i = 1; i < prices.length; i++) {
            if (i == prices.length - 1) {
                max = Math.max(prices[i], max);
                rst += Math.max(max - min - 2 * transFee, 0);
                break;
            }
            if (prices[i] > max) {
                max = prices[i];
            } else if (prices[i] < max) {
                rst += Math.max(max - min - 2 * transFee, 0);
                max = min = prices[i];
            }
        }
        return rst;
    }


    /**
     * the different transactions fee
     *  Single transaction
     * */
    public int getMaxProfit2(int prices[], int[] fee) {
        if (prices.length < 2) {return 0;}
        int min = prices[0] + fee[0], max = prices[0] - fee[0], ret = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i == prices.length - 1) {
                max = Math.max(prices[i] - fee[i], max);
                ret += Math.max(max - min, 0);
                break;
            }
            if (prices[i] - fee[i] > max) {
                max = prices[i] - fee[i];
            } else {
                ret += Math.max(max - min, 0);
                max = prices[i] - fee[i];
                min = prices[i] + fee[i];
            }
        }
        return ret;
    }
}
