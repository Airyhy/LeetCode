package TwoPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words and your method will be called repeatedly many times
 * with different parameters. How would you optimize it?

 Design a class which receives a list of words in the constructor,
 and implements a method that takes two words word1 and word2 and return the shortest distance
 between these two words in the list.

 For example, Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “coding”, word2 = “practice”, return 3. Given word1 = "makes", word2 = "coding", return 1.

 Note: You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 */
public class ShortestWordDistance2 {

    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public ShortestWordDistance2(String[] words) {

        // 统计每个单词出现的下标存入哈希表中
        for(int i = 0; i < words.length; i++){
            List<Integer> cnt = map.get(words[i]);
            if(cnt == null){
                cnt = new ArrayList<Integer>();
            }
            cnt.add(i);
            map.put(words[i], cnt);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> idx1 = map.get(word1);
        List<Integer> idx2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;
        // 每次比较两个下标列表最小的下标，然后把跳过较小的那个
        while(i < idx1.size() && j < idx2.size()){
            distance = Math.min(Math.abs(idx1.get(i) - idx2.get(j)), distance);
            if(idx1.get(i) < idx2.get(j)){
                i++;
            } else {
                j++;
            }
        }
        return distance;
    }
}