//Divide two integers without using multiplication, division and mod operator.
//If it is overflow, return MAX_INT.
//https://leetcode.com/problems/divide-two-integers/

public class DivideTwoIntegers{
	  public int divide(int dividend, int divisor) {
	        if(divisor==0) return Integer.MAX_VALUE;
	        if(dividend ==0) return 0;
	        
	        boolean neg = false;
	        if( (dividend>0 && divisor<0) ||(dividend<0 && divisor>0) )
	            neg = true;
	        
	        
	        //System.out.println(neg);
	        long ldividend = Math.abs((long)dividend);
	        long ldivisor = Math.abs((long)divisor);
	        
	        long ret= 0;
	        while(ldividend >= ldivisor){
	            int shift = 0;
	            while(ldividend > (ldivisor<<shift+1)){
	                shift++;
	            }
	            ldividend -= ldivisor<<shift;
	            ret += (1<<shift);
	        }
	        
	        
	         if (ret > Integer.MAX_VALUE){ //Handle overflow.
	            ret = (neg == true)? Integer.MIN_VALUE:Integer.MAX_VALUE ;
	        } else {
	            ret = (neg == true)?-ret:ret;
	        }
	        return (int)ret;
	    }
}