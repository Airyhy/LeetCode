package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a matrix of lower alphabets and a dictionary.
 * Find all words in the dictionary that can be found in the matrix.
 * A word can start from any position in the matrix and go left/right/up/down to the adjacent position.
 *
 *
 * Given matrix:
 doaf
 agai
 dcan
 and dictionary:
 {"dog", "dad", "dgdg", "can", "again"}

 return {"dog", "dad", "can", "again"}

 dog:
 doaf
 agai
 dcan

 dad:
 doaf
 agai
 dcan

 can:
 doaf
 agai
 dcan

 again:
 doaf
 agai
 dcan
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
