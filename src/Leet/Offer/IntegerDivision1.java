package Leet.Offer;

/*  https://leetcode-cn.com/problems/xoh6Oh/
 * */

public class IntegerDivision1 {
    public int divide(int a, int b) {
        if (a == Integer.MIN_VALUE && b == -1) {
            return Integer.MAX_VALUE;
        }
        if (a > 0) {
            b = -b;
            a = -a;
        }
        boolean flag = true;
        if (b > 0) {
            flag = false;
            b = -b;
        }
        int ans = 0;
        while (a <= b) {
            ans++;
            a -= b;
        }
        if (!flag) {
            ans = -ans;
        }
        return ans;
    }
}
