package VFacebookTemp;

/**
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.

 */
public class RemoveDuplicatesfromSortedArray2 {

    public int removeDuplicates(int[] nums) {

        int len = nums.length;
        if (len <= 2) {
            return len;
        }

        int i = 1, j = 0;
        int cnt = 1;

        for (;i < len;i++) {
            if (nums[i] != nums[i-1]) {
                cnt = 1;
                j++;
                nums[j] = nums[i];
            }
            else {
                if (cnt < 2) {
                    j++;
                    nums[j] = nums[i];
                    cnt++;
                }
            }
        }
        return j+1;
    }

}
