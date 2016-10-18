package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Given a 2D board and a list of words from the dictionary, find all words in the board.
 Each word must be constructed from letters of sequentially adjacent cell,
 where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =

 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Return ["eat","oath"].
 Note:
 You may assume that all inputs are consist of lowercase letters a-z.


 You would need to optimize your backtracking to pass the larger test.
 Could you stop backtracking earlier?

 If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 What kind of data structure could answer such query efficiently?
 Does a hash table work? Why or why not? How about a Trie?
 */

public class wordSearch2 {


    public class Node {
        public Map<Character,Node> sons = new HashMap<Character,Node>();
        public String word = null;
    }

    public Node buildTrie(ArrayList<String> words){
        Node root = new Node();
        for( String word : words){
            Node cur = root;
            for(char ch : word.toCharArray()){
                if( cur.sons.containsKey(ch)==false){
                    cur.sons.put(ch,new Node());
                }
                cur = cur.sons.get(ch);
            }
            cur.word = word;
        }
        return root;
    }

    public void DFS(char[][] board, int i, int j, Node cur, List<String> rlt){
        char c = board[i][j];
        if(cur==null || cur.sons.get(c)==null){
            return;
        }
        cur = cur.sons.get(c);

        if(cur.word!=null){
            if(rlt.contains(cur.word)==false){
                rlt.add(cur.word);
            }
        }

        board[i][j] = '#';
        if(i>0) { DFS(board,i-1,j,cur,rlt); }
        if(j>0) { DFS(board,i,j-1,cur,rlt); }
        if(i<board.length-1) { DFS(board,i+1,j,cur,rlt); }
        if(j<board[0].length-1) { DFS(board,i,j+1,cur,rlt); }
        board[i][j] = c;
    }

    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> rlt = new ArrayList<String>();
        if(words==null || words.size()==0){
            return rlt;
        }

        if(board==null || board[0]==null || board[0].length==0 ){
            return rlt;
        }

        Node root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                DFS(board,i,j,root,rlt);
            }
        }
        return rlt;
    }

}
