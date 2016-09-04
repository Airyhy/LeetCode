package Array;

/**
 *
 Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

 Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 Return 16
 The two words can be "abcw", "xtfn".

 Example 3:
 Given ["a", "aa", "aaa", "aaaa"]
 Return 0
 No such pair of words.


 */
public class MaximumProductofWordLengths {

    public int maxProduct(String[] words) {
        int len = words.length;
        int[] repre = new int[len];
        int[] wordlen = new int[len];
        int max = 0;

        for(int i =0;i<len;i++){
            for(char ch : words[i].toCharArray()){
                repre[i] |= (1<<(ch-'a'));
            }
            wordlen[i] = words[i].length();
        }

        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(i==j) continue;

                if( (repre[i] & repre[j])==0){
                    max = Math.max(wordlen[i]*wordlen[j],max);
                }
            }
        }
        return max;
    }

}
