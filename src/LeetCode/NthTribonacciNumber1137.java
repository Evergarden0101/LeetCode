package LeetCode;

/*  1137. N-th Tribonacci Number
 *   https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * */

public class NthTribonacciNumber1137 {
    public int tribonacci(int n) {
        int[] seq = new int[n + 3];
        seq[0] = 0;
        seq[1] = 1;
        seq[2] = 1;
        int idx = 3;
        while (idx <= n) {
            seq[idx] = seq[idx - 1] + seq[idx - 2] + seq[idx - 3];
            idx++;
        }
        return seq[n];
    }
}
