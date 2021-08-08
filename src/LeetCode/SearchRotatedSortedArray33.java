package LeetCode;

/*  33. Search in Rotated Sorted Array
 *   https://leetcode-cn.com/problems/search-in-rotated-sorted-array/
 * */

public class SearchRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int mid;
        int ans = -1;
        while (l <= r) {
            mid = (l + r) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[nums.length - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return ans;
    }
}
