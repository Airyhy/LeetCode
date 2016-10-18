package VFacebookTemp;

import java.util.*;

/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack,
 or -1 if needle is not part of haystack.
 */
public class ImplementStrStr {

    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }

        int threshold = l1 - l2;
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.substring(i,i+l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    //ordered
    //m * n, O(1)
    public int strStr1(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }

        int hs_p = 0, n_p = 0, ret = -1;
        while (hs_p < haystack.length() && n_p < needle.length()) {
            if (haystack.charAt(hs_p) == needle.charAt(n_p)) {
                if (n_p == 0) {
                    ret = hs_p;
                }
                n_p++;
            } else {
                hs_p = ret == -1 ? hs_p : ret;
                ret = -1;
                n_p = 0;
            }
            hs_p++;
        }
        return n_p == needle.length() ? ret : -1;
    }

    //unordered  permutation
    //m * n, O(n)
    public int strStrPalindrome(String haystack, String needle) {
        int hayLen = haystack.length(), neeLen = needle.length();

        if (hayLen < neeLen) {
            return -1;
        }
        if (needle == "") {
            return 0;
        }

        List<Integer> list = new ArrayList<>(Collections.nCopies(26, 0));

        for (int i = 0; i < neeLen; i++) {
            list.set(needle.charAt(i) - 'a', list.get(needle.charAt(i) - 'a') + 1);
        }

        int left = 0, i = 0;
        int ret = -1;
        List<Integer> temp = new ArrayList<>(list);
        for (int j = 0; j < hayLen && i < neeLen; ) {
            char c = haystack.charAt(j);
            if (temp.get(c - 'a') != 0) {
                ret = ret == -1 ? j : ret;
                temp.set(c - 'a', temp.get(c - 'a') - 1);
                i++;
                j++;
            } else {
                left++;
                temp = new ArrayList<>(list);
                ret = -1;
                i = 0;
                j = left;
            }
        }

        return i == neeLen ? ret : -1;

    }

    public int strStrPalindrome1(String haystack, String needle) {
        int hayLen = haystack.length(), neeLen = needle.length();

        if (hayLen < neeLen) {
            return -1;
        }
        if (needle == "") {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < neeLen; i++) {
            char c = needle.charAt(i);
            map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
        }

        int left = 0, i = 0;
        int ret = -1;
        Map<Character, Integer> currMap = new HashMap<>(map);
        for (int j = 0; j < hayLen && i < neeLen; ) {
            char c = haystack.charAt(j);
            if (currMap.containsKey(c) && map.get(c) > 0) {
                currMap.put(c, currMap.get(c) - 1);
                i++;
                j++;
                ret = ret == -1 ? j : ret;
            } else {
                left++;
                currMap = new HashMap<>(map);
                ret = -1;
                i = 0;
                j = left;
            }

        }

        return i == neeLen ? ret : -1;

    }

    public static void main(String[] args) {
        ImplementStrStr a = new ImplementStrStr();
        System.out.println(a.strStr("helloworld", "he"));
        System.out.println(a.strStr("helloworld", "l"));
        System.out.println(a.strStr("helloworld", "o"));
        System.out.println(a.strStr("helloworld", "ld"));
        System.out.println(a.strStr("helloworld", "ee"));
    }

}
