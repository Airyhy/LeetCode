package DP.DP_seuqence;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 */
public class climbStairs {


    public int nthFibonacci (int n){
        return 1;
    }


    public int climbStairs(int n) {
        // write your code here
        if(n<=1) return 1;
        int[] meth = new int[n];
        meth[0] = 1;
        meth[1] = 2;
        for(int i=2;i<n;i++){
            meth[i] =  meth[i-1] + meth[i-2];
        }
        return meth[n-1];
    }
}
