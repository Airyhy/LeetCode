package DP.DP_game;

import java.util.Arrays;

/**
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class ScrambleString {

    public boolean isScramble(String s1, String s2) {
        // Write your code here
        //System.out.println(s1+" "+s2);
        if(s1.equals(s2)){return true;}

        int len = s1.length();
        int[] s1c = new int[26];
        int[] s2c = new int[26];
        for(int i=0;i<len;i++){
            s1c[s1.charAt(i)-'a']++;
            s2c[s2.charAt(i)-'a']++;
        }
        if(!Arrays.equals(s1c,s2c)){
            return false;

        }

        for(int i=1;i<len;i++){
            boolean check1 = isScramble(s1.substring(0,i),s2.substring(0,i)) &&
                    isScramble(s1.substring(i),s2.substring(i));
            boolean check2 = isScramble(s1.substring(0,i),s2.substring(len-i)) &&
                    isScramble(s1.substring(i),s2.substring(0,len-i));
            if( check1 || check2 ){
                //   System.out.println(true);
                return true;
            }
        }

        return false;
    }
}
