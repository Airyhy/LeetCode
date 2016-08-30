package TwoPointer;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.

 Trapping Rain Water

 Have you met this question in a real interview? Yes
 Example
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

public class trapRainWater {

    public int trapRainWater(int[] heights) {
        if(heights==null || heights.length<3){
            return 0;
        }

        int vol = 0;
        int low = 0, hi = heights.length - 1;
        int maxl = heights[low], maxh = heights[hi];

        while(low < hi){
            maxl = Math.max(maxl, heights[low]);
            maxh = Math.max(maxh, heights[hi]);

            if(maxl>maxh){
                vol += (maxh - heights[hi]);
                hi--;

            } else {
                vol += (maxl - heights[low]);
                low++;
            }
        }

        return vol;
    }

}
