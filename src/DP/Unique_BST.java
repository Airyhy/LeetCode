package DP;

/**
 * Created by haoyangyuan on 8/26/16.
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3



 Given a sequence 1…n, we pick a number i out of the sequence as the root,
 then the number of unique BST with the specified root F(i),
 is the cartesian product of the number of BST for its left and right subtrees.

 For example, F(3, 7): the number of unique BST tree with number 3 as its root.
 To construct an unique BST out of the entire sequence [1, 2, 3, 4, 5, 6, 7] with 3 as the root,
 which is to say, we need to construct an unique BST out of its left subsequence [1, 2] and
 another BST out of the right subsequence [4, 5, 6, 7], and then combine them together (i.e. cartesian product).

 The tricky part is that we could consider the number of unique BST out of sequence [1,2] as G(2),
 and the number of of unique BST out of sequence [4, 5, 6, 7] as G(4). Therefore, F(3,7) = G(2) * G(4).

 G(n) = F(1, n) + F(2, n) + ... + F(n, n).

 F(i, n) = G(i-1) * G(n-i)	1 <= i <= n
 */
public class Unique_BST {
i
    public int numTrees(int n) {
        if(n==0) {
            return 1;
        } else if (n==1){
            return 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=1; j<=i; j++){
                dp[i] += (dp[i-j] * dp[j-1]);
            }
        }
        return dp[n];
    }

}
