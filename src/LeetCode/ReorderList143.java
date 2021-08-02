package LeetCode;

/*  143. Reorder List
 *   https://leetcode-cn.com/problems/reorder-list/
 * */

import java.util.ArrayList;
import java.util.List;

public class ReorderList143 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            list.get(i).next = list.get(n - i - 1);
            list.get(n - i - 1).next = list.get(i + 1);
//            if(n%2==0&&i==n/2-1){
//                list.get(n-i-1).next=null;
//            }
//            if(i==n/2){
//                list.get(i).next=null;
//            }
        }
        list.get(n / 2).next = null;
    }
}
