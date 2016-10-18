package VFacebookTemp;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of words and a length L, format the text such that each line
 * has exactly L characters and is fully (left and right) justified.

 You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
 Pad extra spaces ' ' when necessary so that each line has exactly L characters.

 Extra spaces between words should be distributed as evenly as possible.
 If the number of spaces on a line do not divide evenly between words,
 the empty slots on the left will be assigned more spaces than the slots on the right.

 For the last line of text, it should be left justified and no extra space is inserted between words.

 For example,
 words: ["This", "is", "an", "example", "of", "text", "justification."]
 L: 16.

 Return the formatted lines as:
 [
 "This    is    an",
 "example  of text",
 "justification.  "
 ]
 */
public class TextJustification {

    /**
     *
     I divide the solution to this question into two parts:

     one is for counting the valid number of words which can fit into one line,
     i.e. helper() function does it and also passes the next index to be traversed in the next turn
     (it can be modified as iterative way if you are more comfortable with).

     the other part serves as a string editor, i.e. addList() uses the actual valid words lengths (len) and index of start (i, inclusive)
     and end (j, exclusive) to count the spaces to be added.
     */


    private List<String> result;

    public List<String> fullJustify(String[] words, int maxWidth) {
        result = new ArrayList<String>();
        if (words == null || words.length == 0 || maxWidth < 0) return result;
        if (maxWidth == 0) {
            result.add("");
            return result;
        }
        helper(words, 0, maxWidth);
        return result;
    }

    public void helper(String[] words, int start, int L) {
        if (start >= words.length) return;

        int i = start, len = 0, total = 0, next = -1;
        while (total < L && i < words.length) {
            total += words[i].length();
            if (total > L) { // only in this case we need skip i++
                next = i;
                break;
            }
            len += words[i].length();
            total++; // count space
            i++;
        }

        if (next == -1) next = i;
        addList(words, start, next, len, L);

        helper(words, next, L);
    }

    public void addList(String[] words, int i, int j, int len, int L) {
        StringBuilder sb = new StringBuilder("");
        int count = j-i-1, space = 0, more = 0, s = 0;
        if (count == 0 || j == words.length) { // the last line
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                if (k == j-1) break;
                sb.append(" ");
            }
            space = L - sb.length();
            s = 0;
            while (s++ < space) sb.append(" ");
        } else {
            space = (L - len) / count; more = (L - len) % count;
            for (int k = i; k < j; k++) {
                sb.append(words[k]);
                s = 0;
                if (k == j-1) break;
                while (s++ < space) sb.append(" ");
                if (more-- > 0) sb.append(" ");
            }
        }

        result.add(sb.toString());
    }
}
