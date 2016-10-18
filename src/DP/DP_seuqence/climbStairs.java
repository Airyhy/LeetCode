package DP.DP_seuqence;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?


 */
public class climbStairs {


    /**
     * Recursive
     */
    static int nthFibonacci(int n)
    {
        if (n <= 1)
            return n;
        return nthFibonacci(n-1) + nthFibonacci(n-2);
    }


    /**
     * DP
     */
    static int nthFibonacci1(int n)
    {
        /* Declare an array to store Fibonacci numbers. */
        int f[] = new int[n+1];
        int i;

    /* 0th and 1st number of the series are 0 and 1*/
        f[0] = 0;
        f[1] = 1;

        for (i = 2; i <= n; i++)
        {
       /* Add the previous 2 numbers in the series
         and store it */
            f[i] = f[i-1] + f[i-2];
        }

        return f[n];
    }


    /**
     * DP space optimization
     */
    int nthFibonacci2(int n)
    {
        int a = 0, b = 1, c, i;
        if( n == 0)
            return a;
        for (i = 2; i <= n; i++)
        {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
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
