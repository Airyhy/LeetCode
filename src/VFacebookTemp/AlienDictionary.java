package VFacebookTemp;

import java.util.*;

/**
 There is a new alien language which uses the latin alphabet.
 However, the order among letters are unknown to you.
 You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language.
 Derive the order of letters in this language.

 For example,
 Given the following words in dictionary,

 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 The correct order is: "wertf".

 Note:
 You may assume all letters are in lowercase.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */
public class AlienDictionary {


    /**
     *
     * -1 means not exisitng
     *  0 means no dgree, could be used as first one
     *  1 means have one prerequists
     *
     */
    private final int N = 26;

    public String alienOrder(String[] words) {
        List<Set<Integer>> adj = new ArrayList<>(N);
        int[] degree = new int[N];

        //build graph first to get all the relationships and degrees
        //return false, if it is invalid like ["abc","ab"]
        if(!buildGraph(words, adj, degree)){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Integer> q = new LinkedList<>();
        //all the nodes can be used first
        for(int i = 0; i < N; i++) {
            if(degree[i] == 0) q.add(i);
        }

        // peeling 0 indegree nodes
        while(!q.isEmpty()) {
            int i = q.poll();
            sb.append((char) ('a' + i));
            for(int j : adj.get(i)) {
                if(--degree[j] == 0) {
                    q.add(j);
                }
            }
        }
        for(int d : degree) if(d > 0) return "";  // invalid
        return sb.toString();
    }

    public boolean buildGraph(String[] words, List<Set<Integer>> adj, int[] degree) {
        for(int i = 0; i < N; i++) adj.add(new HashSet<Integer>());
        Arrays.fill(degree, -1);

        for(int i = 0; i < words.length; i++) {

            //add to the existing list
            for(char c : words[i].toCharArray()) {
                if(degree[c - 'a'] < 0) degree[c - 'a'] = 0;
            }

            if(i==0) { continue; }

            String w1 = words[i - 1], w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            int j = 0;
            for(; j < len; j++) {
                if(w1.charAt(j) != w2.charAt(j)) {
                    int c1 = w1.charAt(j) - 'a', c2 = w2.charAt(j) - 'a';
                    // c1 -> c2, c1 is lexically earlier to c2.
                    if(!adj.get(c1).contains(c2)) {
                        adj.get(c1).add(c2);
                        degree[c2]++;
                    }
                    break;
                }
            }
            if(w1.length() > w2.length() && j==len){ return false; }
        }
        return true;
    }


    /**
     For DFS
     visited[i] = -1. Not even exist.
     visited[i] = 0. Exist. Non-visited.
     visited[i] = 1. Visiting.
     visited[i] = 2. Visited.
     */
}
