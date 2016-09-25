package Math;//Amazon

public class CountPrime{
	public static void main(String[] args){

	}

    /**
     * Description:

     Count the number of prime numbers less than a non-negative number, n.
     */
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = i; j < n; j = j+i) {
                    notPrime[j] = true;
                }
            }
        }

        return count;
    }

    //rule out even number first, then check up to the square root
	public static boolean isPrime2(int num) {
            if (num <= 1) {
                return false;
            }
            if (num == 2) {
                return true;
            }
            if (num % 2 == 0) {
                return false;
            }
            for (int i = 3; i <= Math.sqrt(num) + 1; i = i + 2) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }

}