package Greedy;

import java.util.Arrays;

/**There are N children standing in a line. Each child is assigned a rating value.

    You are giving candies to these children subjected to the following requirements:
    Each child must have at least one candy.
    Children with a higher rating get more candies than their neighbors.
    What is the minimum candies you must give?
*/

 public class Candy {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candies = new int[len];
        
        Arrays.fill(candies,1);

        for(int i=1;i<len;i++){
            int left;            
            left = ratings[i-1];
            
            if(ratings[i]>left){
                candies[i] = candies[i-1]+1;
            }
        }
        
        for(int i=len-2;i>=0;i--){
            int right;
            right = ratings[i+1];
            
            if(ratings[i]>right){
                candies[i] = Math.max(candies[i],candies[i+1]+1);
            }
        }

        int cnt = 0;
        for(int candy : candies){
            cnt += candy;
        }
        return cnt;
    }
}
