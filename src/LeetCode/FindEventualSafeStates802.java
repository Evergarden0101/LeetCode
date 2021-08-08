package LeetCode;

/*  802. Find Eventual Safe States
 *  https://leetcode-cn.com/problems/find-eventual-safe-states/
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindEventualSafeStates802 {
    int[] safe;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        safe = new int[graph.length];
        Arrays.fill(safe, -1);
        int idx = -1;
        for (int i = 0; i < graph.length; i++) {
            if (safe[i] != -1) continue;
            if (graph[i].length == 0) {
                safe[i] = 1;
                continue;
            }
            findSafe(graph, i, idx);
            idx++;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < safe.length; i++) {
            if (safe[i] == 1) {
                ans.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }

    public int findSafe(int[][] graph, int i, int idx) {
        System.out.println(i);
        System.out.println(safe[i]);
        System.out.println(graph[i].length);
        System.out.println();
        if (safe[i] != -1) return safe[i];
        if (graph[i].length == 0) {
            safe[i] = 1;
            return safe[i];
        }
        int flag = 1;
        for (int j = 0; j < graph[i].length; j++) {
            int temp = graph[i][j];
            flag *= findSafe(graph, temp, idx);
            if (flag == 0) break;
        }
        safe[i] = flag;
        return safe[i];
    }

    public static void main(String[] args) {
        FindEventualSafeStates802 findEventualSafeStates = new FindEventualSafeStates802();
        int[][] graph = {{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}};
        System.out.println(findEventualSafeStates.eventualSafeNodes(graph));
    }
}
