package VFacebookTemp;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the word list
 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */

public class WordLadder{
	public int ladderLength(String start, String end, Set<String> dict) {
		//no words in dictionary
		if(dict.size()==0){
			return 0;
		}

		if(start.equals(end)) {
			return 1;
		}
		//queue to store words and distances from starting word
		Queue<String> words = new LinkedList<String>();
		Queue<Integer> dist = new LinkedList<Integer>();

		//initial condition
		words.offer(start);
		dist.offer(1);
		while(!words.isEmpty()){
			String curr = words.poll();
			int currDist = dist.poll();
			int len = curr.length();

			//try each position
			for(int i=0; i<len; i++){
				char[] currChar = curr.toCharArray();
				//try each character
				for(int j='a'; j<='z'; j++){
					currChar[i] = (char)j;
					String temp = new String(currChar);

					//find target
					if(temp.equals(end)){
						return currDist+1;
					}

					//intermediate word is in dictionary
					if(dict.contains(temp)){
						words.offer(temp);
						dist.offer(currDist+1);
						dict.remove(temp);
					}
				}
			}
		}
		return 0;
	}
}