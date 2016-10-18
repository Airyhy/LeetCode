package VFacebookTemp;

/**
 *
 * Implement pow(x, n).
 */


public class Pow {


	/**
	 *  x^n
	 */
	public double myPow(double x, int m) {
		double temp=x;

		if(m==0) {
			return 1;
		}

		temp=myPow(x,m/2);

		if(m%2==0)
			return temp*temp;
		else
		{
			if(m > 0)
				return x*temp*temp;
			else
				return (temp*temp)/x;
		}
	}


	public double myPow1(double x, int n) {
		double ans = 1;
		long absN = Math.abs((long)n);

		while(absN > 0) {
			if((absN&1)==1) {
				ans = ans * x;
			}
			absN = absN >> 1;
			x = x * x;
		}

		return n < 0 ?  1/ans : ans;

	}


}

