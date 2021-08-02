package LeetCode;

/*  1823. Find the Winner of the Circular Game
 *   https://leetcode-cn.com/problems/find-the-winner-of-the-circular-game/
 * */


import java.util.ArrayList;
import java.util.List;

public class CircularGameWinner1823 {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int start = 0;
        while (list.size() > 1) {
            start = (start + k - 1) % list.size();
            list.remove(start);
        }
        return list.get(0);
    }
}
