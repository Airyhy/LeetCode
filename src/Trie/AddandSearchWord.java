package Trie;

import java.util.HashMap;
import java.util.Map;

/**
 * Iterator a data structure that supports the following two operations: addWord(word) and search(word)

 search(word) can search a literal word or a regular expression string containing only letters a-z or ..

 A . means it can represent any one letter.

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad")  // return false
 search("bad")  // return true
 search(".ad")  // return true
 search("b..")  // return true
 */
public class AddandSearchWord {

    public Node root = new Node();

    public class Node{
        boolean isWord = false;
        Map<Character,Node> sons = new HashMap<>();
    }
    // Adds a word into the data structure.
    public void addWord(String word) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.sons.containsKey(c)) {
                cur.sons.put(c, new Node());
            }
            cur = cur.sons.get(c);
        }
        cur.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return DFS(0,word,root);
    }

    public boolean DFS(int index, String word, Node cur){
        if(index==word.length()){
            return cur.isWord;
        }

        char ch = word.charAt(index);
        if(ch=='.') {
            for( char each : cur.sons.keySet()){
                Node next = cur.sons.get(each);
                if( DFS(index+1,word,next)){
                    return true;
                }
            }
            return false;
        } else {
            if(cur.sons.containsKey(ch)==false){
                return false;
            }
            Node next = cur.sons.get(ch);
            return DFS(index+1,word,next);
        }
    }

}
