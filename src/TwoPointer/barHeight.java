package TwoPointer;

//find the point at which the water level is the highest,
//return the water level at the position
//bar height问题：这是Amazon面试中的一道问题。求最高的液面高度。
//这里只需要把上方的代码修改一下就可以用。就是在res值变更时，
//若max与当前高度差值非零时，记录下max值，最后最高的max值就是结果。
public class barHeight{
	public static void main(String[] args){
		int[] elevation = new int[]{1,2,3,1,3};
		System.out.println(highestWaterLevel(elevation));

	}

	public static int highestWaterLevel(int[] height) {
        if(height.length==0) return 0;
        int cont = 0;
        int a = 0, b = height.length - 1;
        int res = 0;
        int left = height[a], right = height[b];
        
        while(a<b){
            if(left<=right){
                res = Math.max(res,left);
                a++;
            }
            else{
                res = Math.max(res,right);
                b--;
            }
            // System.out.println(cont);
            left = Math.max(left,height[a]);
            right = Math.max(right,height[b]);
        }
        return cont;
    

	}
}