package LeetCode;

/*  34. Find First and Last Position of Element in Sorted Array
 *   https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * */

public class ElementFirstLastPositionInSortedArray34 {
    public int[] searchRange(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        int s = -1, e = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                s = mid;
                while (s >= 0 && nums[s] == target) {
                    s--;
                }
                s++;
                e = mid;
                while (e < nums.length && nums[e] == target) {
                    e++;
                }
                e--;
                break;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            }
        }
        int[] ans = {s, e};
        return ans;
    }
}
