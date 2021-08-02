package LeetCode;

/*  743. Network Delay Time
 *   https://leetcode-cn.com/problems/network-delay-time/
 * */

import java.util.Arrays;
import java.util.HashSet;

public class NetworkDelayTime743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[][] graph = new int[n][n];
        int[] ans = new int[n];
        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], max);
        }
        Arrays.fill(ans, max);
        ans[k - 1] = 0;
        for (int[] way : times) {
            graph[way[0] - 1][way[1] - 1] = way[2];
        }
        for (int i = 0; i < n; i++) {
            int idx = -1;
            for (int j = 0; j < n; j++) {
                if (!set.contains(j) && (idx == -1 || ans[j] < ans[idx])) {
                    idx = j;
                }
                System.out.println(ans[j]);
            }
            set.add(idx);
            System.out.println(idx);
            for (int[] way : times) {
                if (way[0] - 1 == idx) {
                    ans[way[1] - 1] = Math.min(ans[idx] + way[2], ans[way[1] - 1]);
                }
            }
            System.out.println();
        }
        int delay = ans[0];
        for (int i : ans) {
            if (i > delay) delay = i;
        }
        if (delay > 100) return -1;
        return delay;
    }

    public static void main(String[] args) {
        NetworkDelayTime743 networkDelayTime = new NetworkDelayTime743();
        int[][] times = {{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime.networkDelayTime(times, 4, 2));
    }
}
