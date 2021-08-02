package LeetCode;

/*  155. Min Stack
 *   https://leetcode-cn.com/problems/min-stack/
 * */

import java.util.Stack;

public class MinStack151 {
    Stack<Integer> stack;
    Stack<Integer> min;

    /**
     * initialize your data structure here.
     */
    public MinStack151() {
        stack = new Stack<>();
        min = new Stack<>();
        min.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        if (val < min.peek()) min.push(val);
        else min.push(min.peek());
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args) {
        MinStack151 minStack151 = new MinStack151();
        minStack151.push(1);
        System.out.println(minStack151.getMin());
        System.out.println(minStack151.getMin());
    }
}
