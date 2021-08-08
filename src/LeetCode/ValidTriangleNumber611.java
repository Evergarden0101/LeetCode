package LeetCode;

/*  611. Valid Triangle Number
 *   https://leetcode-cn.com/problems/valid-triangle-number/
 * */

import java.util.Arrays;

public class ValidTriangleNumber611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int res = 0;
        for (int i = n - 1; i >= 2; --i) {
            int l = 0, r = i - 1;
            while (l < r) {
                if (nums[l] + nums[r] > nums[i]) {
                    res += r - l;
                    --r;
                } else {
                    ++l;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        ValidTriangleNumber611 validTriangleNumber = new ValidTriangleNumber611();
        int[] nums = {4, 2, 3, 4};
        System.out.println(validTriangleNumber.triangleNumber(nums));
    }
}
