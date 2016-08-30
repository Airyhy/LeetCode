package QuickSort;

/**
 * Given a set of n nuts of different sizes and n bolts of different sizes.
 * There is a one-one mapping between nuts and bolts.
 * Comparison of a nut to another nut or a bolt to another bolt is not allowed.
 * It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

 We will give you a compare function to compare nut with bolt.

 Example
 Given nuts = ['ab','bc','dd','gg'], bolts = ['AB','GG', 'DD', 'BC'].

 Your code should find the matching bolts and nuts.

 one of the possible return:

 nuts = ['ab','bc','dd','gg'], bolts = ['AB','BC','DD','GG'].

 we will tell you the match compare function. If we give you another compare function.

 the possible return is the following:

 nuts = ['ab','bc','dd','gg'], bolts = ['BC','AA','DD','GG'].

 So you must use the compare function that we give to do the sorting.

 */
public class NutsAndBolts {


    /**
     * public class NBCompare {
     *     public int cmp(String a, String b);
     * }
     * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
     * if "a" is bigger than "b", it will return 1, else if they are equal,
     * it will return 0, else if "a" is smaller than "b", it will return -1.
     * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
     */

    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts==null || bolts==null || nuts.length!=bolts.length){
            return;
        }
        qsort(nuts, bolts, compare,0, nuts.length-1);
    }

    public void qsort(String[] nuts, String[] bolts, NBComparator compare, int lo, int hi){
        if(lo >= hi) return;
        int pivot = part(nuts, bolts[lo], compare, lo, hi);
        part(bolts, nuts[pivot],  compare,  lo,  hi);

        qsort(nuts, bolts, compare,lo, pivot - 1);
        qsort(nuts, bolts, compare,pivot+1, hi);
    }

    public int part(String[] nuts, String bolt, NBComparator compare, int lo, int hi){
        for (int i = lo; i <= hi; i++) {
            if (compare.cmp(nuts[i], bolt) == 0 ||
                    compare.cmp(bolt, nuts[i]) == 0) {
                swap(nuts, i, lo);
                break;
            }
        }

        String tmp = nuts[lo];
        while(lo<hi){
            while (lo < hi &&  (compare.cmp(nuts[hi], bolt) == -1 ||
                    compare.cmp(bolt,nuts[hi]) == 1)){
                hi--;
            }
            nuts[lo] = nuts[hi];
            while (lo < hi &&  (compare.cmp(nuts[lo], bolt) == 1 ||
                    compare.cmp(bolt,nuts[lo]) == -1)){
                lo++;
            }
            nuts[hi] = nuts[lo];
        }
        nuts[lo] = tmp;
        return lo;
    }

    private void swap(String[] str, int l, int r) {
        String temp = str[l];
        str[l] = str[r];
        str[r] = temp;
    }
}
