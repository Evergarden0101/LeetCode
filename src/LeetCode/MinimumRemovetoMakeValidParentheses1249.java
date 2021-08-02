package LeetCode;

/*  1249. Minimum Remove to Make Valid Parentheses
 *   https://leetcode-cn.com/problems/minimum-remove-to-make-valid-parentheses/
 * */

import java.util.HashSet;
import java.util.Stack;

public class MinimumRemovetoMakeValidParentheses1249 {
    public String minRemoveToMakeValid(String s) {
        char[] ss = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        HashSet<Integer> del = new HashSet<>();
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] == '(') {
                stack.push(i);
            } else if (ss[i] == ')') {
                if (stack.size() != 0) {
                    stack.pop();
                } else {
                    del.add(i);
                }
            }
        }
        while (stack.size() != 0) {
            del.add(stack.peek());
            stack.pop();
        }
        String ans = "";
        for (int i = 0; i < ss.length; i++) {
            if (del.contains(i)) continue;
            ans += ss[i];
        }
        return ans;
    }
}
