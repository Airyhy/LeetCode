package Stack;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.

 histogram

 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 histogram

 The largest rectangle is shown in the shaded area, which has area = 10 unit.

 Have you met this question in a real interview? Yes
 Example
 Given height = [2,1,5,6,2,3],
 return 10.

 */
public class LargestRectangleinHistogram {

    public int largestRectangleArea(int[] height) {
        // write your code here
        int max = 0;
        Stack<Integer> st = new Stack<Integer>();

        for(int i=0;i<=height.length;i++){
            int cur;
            if(i==height.length){
                cur = -1;
            }else{
                cur = height[i];
            }

            while(st.isEmpty()==false && cur<=height[st.peek()]){
                int h = height[st.pop()];
                int x;
                if(st.isEmpty()) {
                    x = i;
                } else {
                    x = i - st.peek() - 1;
                }

                max = Math.max(max, h*x);
            }
            st.push(i);
        }
        return max;
    }

}
