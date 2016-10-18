package DP.DP_seuqence;

import java.util.List;

/**
 Given a triangle, find the minimum path sum from top to bottom.
 Each step you may move to adjacent numbers on the row below.

 For example, given the following triangle
 [
    [2],
   [3,4],
  [6,5,7],
 [4,1,8,3]
 ]
 The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 */

public class TriangleMinPath{
	public int minimumTotal(List<List<Integer>> triangle) {
		int size = triangle.size();
		if(size == 1){
			return triangle.get(0).get(0);
		}

		int[] dp = new int[size];
         //initial condition by last row
		for(int i=0; i<size; i++){
			dp[i] = triangle.get(size-1).get(i);
		}

		for(int i=size-2; i>=0; i--){
			int len = triangle.get(i).size();
			for(int j=0; j<len; j++){

                //update by min(two adjacent values in current row) + value in the row above
				dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
				//if want maximum sum
				//use dp[j] = Math.max(dp[j],dp[j+1]) + triangle.get(i).get(j);
			}
		}
		return dp[0];
	}
}