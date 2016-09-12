package Array;

import java.util.LinkedList;
import java.util.List;

/**
 * LRU cache. 给一个array, 给一个cache max size, 输出miss count. 什么时候hit, 什么时候miss的情况写好就好了。
 example：   size = 4， input array   【1，2，3，4，5，4，1】
 1 miss   2 miss   3 miss   4 miss   5 miss  替换 1
 4 hit    把4提前到第一位   1 miss  替换 2

 */
public class LRUmissCount {

    public static int count(int[] arr, int size) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        List<Integer> cache = new LinkedList<>();
        int count = 0;

        for (int num : arr) {
            int index = cache.indexOf(num);
            if (index >= 0) {
                cache.remove(index);
                cache.add(num);
            } else {
                cache.add(num);
                count++;
            }
            if (cache.size() > size) {
                cache.remove(0);
            }
        }
        return count; }


}
