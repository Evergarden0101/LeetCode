package LeetCode;

/*  1337. The K Weakest Rows in a Matrix
 *   https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * */

import java.util.Arrays;

public class TheKWeakestRowsInAMatrix1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] ans = new int[mat.length][2];
        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    count++;
                }
            }
            ans[i][0] = i;
            ans[i][1] = count;
        }
        Arrays.sort(ans, (int[] a, int[] b) -> a[1] - b[1]);
        int[] out = new int[k];
        for (int i = 0; i < k; i++) {
            out[i] = ans[i][0];
        }
        return out;
    }
}
