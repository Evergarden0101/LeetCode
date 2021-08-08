package LeetCode;

/*  581. Shortest Unsorted Continuous Subarray
 *   https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * */

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray581 {
    public int findUnsortedSubarray(int[] nums) {
        int[] sort = nums.clone();
        Arrays.sort(sort);
        int l = -1, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sort[i] != nums[i]) {
                if (l == -1) l = i;
                else r = i;
            }
        }
        if (l == -1) return 0;
        else return r - l + 1;
    }
}
