intersecimport java.util.*;

/**
 * Created by Christina on 2/19/16.
 */
public class IntersectionOfTwoArrays {

    //no duplicate

    /**
     * put one array into the set
     *
     * */
    public List<Integer> intersction(int[] nums1, int nums2[]) {
        Set<Integer> ret = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                ret.add(nums2[i]);
            }
        }
        return new ArrayList<>(ret);
    }


    /**
     *  unsorted array to get intersection
     *  Use map, if duplicate to count the times, and add according to existing time
     */
    private static Set<Character> intersect1(char[] a, char[] b) {
        Collection listOne = new ArrayList(Arrays.asList("milan","dingo", "elpha", "hafil", "meat", "iga", "neeta.peeta"));
        Collection listTwo = new ArrayList(Arrays.asList("hafil", "iga", "binga", "mike", "dingo"));

        listOne.retainAll( listTwo );
        return new HashSet<>(listOne);
    }

    //sort it first
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }


    //has duplicate

    /**
     * Use Map to count the times
     */
    public List<Integer> intersctionDup(int[] nums1, int nums2[]) {
        List<Integer> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.containsKey(nums1[i]) ? map.get(nums1[i]) + 1 : 1);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                ret.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        return ret;
    }

    /**
     * Two pointers
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1==null || nums1.length==0){
            return nums1;
        } else if(nums2==null || nums2.length==0){
            return nums2;
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pnt1 = 0;
        int pnt2 = 0;
        ArrayList<Integer> myList = new ArrayList<Integer>();
        while((pnt1 < nums1.length) &&(pnt2< nums2.length)){
            if(nums1[pnt1]<nums2[pnt2]){
                pnt1++;
            }
            else{
                if(nums1[pnt1]>nums2[pnt2]){
                    pnt2++;
                }
                else{
                    myList.add(nums1[pnt1]);
                    pnt1++;
                    pnt2++;
                }
            }
        }
        int[] res = new int[myList.size()];
        for(int i = 0; i<res.length; i++){
            res[i] = (Integer)myList.get(i);
        }
        return res;
    }

    public static void main(String[] arg) {
        IntersectionOfTwoArrays a = new IntersectionOfTwoArrays();
        System.out.println(a.intersction(new int[]{1, 2, 3, 4, 1, 1}, new int[]{1, 1,3,2, 2}));
        System.out.println(a.intersctionDup(new int[]{1, 2, 3, 4, 1, 1}, new int[]{1, 1, 3, 2, 2}));
    }
}
