package VFacebookTemp;

import java.util.Random;

/**
 Given an array of integers with possible duplicates, randomly output the index of a given target number.
 You can assume that the given target number must exist in the array.

 Note:
 The array size can be very large. Solution that uses too much extra space will not pass the judge.

 Example:

 int[] nums = new int[] {1,2,3,3,3};
 Solution solution = new Solution(nums);

 // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 solution.pick(3);

 // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 solution.pick(1);
 */
public class RandomPickIndex {


    int[] nums;
    Random rnd;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }

    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;

            //store i to the result with 1/n possibility
            if (rnd.nextInt(++count) == 0)
                result = i;
        }

        return result;
    }

    /**
     Reservoir Sampling
     Reservoir sampling is a family of randomized algorithms for randomly choosing k samples from a list of n items,
     where n is either a very large or unknown number.

     Typically n is large enough that the list doesn’t fit into main memory.
     For example, a list of search queries in Google and Facebook.

     */

    // A function to randomly select k items from stream[0..n-1].
    void selectKItems(int stream[], int n, int k)
    {
        int i;  // index for elements in stream[]

        // reservoir[] is the output array. Initialize it with
        // first k elements from stream[]
        int[] reservoir= new int[k];
        for (i = 0; i < k; i++)
            reservoir[i] = stream[i];

        // Use a different seed value so that we don't get
        // same result each time we run this program
        Random rd= new Random();

        // Iterate from the (k+1)th element to nth element
        for (; i < n; i++)
        {
            // Pick a random index from 0 to i.
            int j = rnd.nextInt(i+1);

            // If the randomly  picked index is smaller than k, then replace
            // the element present at the index with new element from stream
            if (j < k)
                reservoir[j] = stream[i];
        }
    }

}
