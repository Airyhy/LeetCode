package TwoPointer;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxvol = 0;
        if(height.length<2){
            return maxvol;
        }
        int i =0;
        int j = height.length - 1;
        while(i<j){
            maxvol = Math.max( maxvol , (j-i)*Math.min(height[i],height[j]) );
            if(height[i]<height[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return maxvol;
    }

}
