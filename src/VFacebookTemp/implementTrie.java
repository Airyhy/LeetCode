package VFacebookTemp;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement a trie with insert, search, and startsWith methods.
 */
public class implementTrie {

    class TrieNode {
        // Initialize your data structure here.
        boolean isWord;
        Map<Character,TrieNode> sons;

        public TrieNode() {
            sons = new HashMap<Character,TrieNode>();
        }
    }

    public class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {

                //System.out.println(cur==null);

                if (cur.sons.containsKey(ch) == false) {
                    cur.sons.put(ch, new TrieNode());
                }
                cur = cur.sons.get(ch);
            }
            cur.isWord = true;
        }

        // Returns if the word is in the trie.
        public boolean search(String word) {
            TrieNode cur = root;
            for (char ch : word.toCharArray()) {
                if (cur.sons.containsKey(ch) == true) {
                    cur = cur.sons.get(ch);
                } else {
                    return false;
                }
            }
            if (cur.isWord == true) {
                return true;
            }
            return false;
        }

        // Returns if there is any word in the trie
        // that starts with the given prefix.
        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                if (cur.sons.containsKey(ch) == true) {

                    cur = cur.sons.get(ch);
                } else {
                    return false;
                }
            }
            return true;
        }
    }
}
