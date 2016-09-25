package Array;

/**
 *
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.

http://blog.csdn.net/kenden23/article/details/17099987
https://leetcode.com/problems/first-missing-positive/

 */

public class FirstMissingPositive{
	public int firstMissingPositive(int[] A) {
        int n = A.length;
        for (int i=0; i<n; i++)  
        {  
            if (A[i] > 0 && A[i] < n)  
            {  
                //if (A[i]-1 != i && A[A[i]-1] != A[i])不用那么多条件就可以了。  
                //因为只要是已经到位了的元素即：A[i]-1==i了，那么判断如果有重复元素  
                //两个位置交换就最好考虑好两个位置出现的可能情况。考虑问题全面，两个条件都考虑好。  
                //update:增加i!=A[i]表示i位置没到位，A[A[i]-1] != A[i]表示A[i]-1位置没到位，两个位置都判断也很好的。  
                if (A[A[i]-1] != A[i])  
                {  
                    swap(A[i]-1, i,A);  
                    i--;  
                }  
            }  
        }  
  
        for (int j=0; j<n; ++j)  
            if (A[j]-1 != j)  
                return j+1;  
  
        return n+1;   
    }
    
    public void swap(int a,int b,int[] A){
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}