package LeetCode;

/*  25. Reverse Nodes in k-Group
 *   https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * */

public class ReverseNodesInKGroup25 {
    class ListNode {
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

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head.next == null || head == null) return head;
        ListNode p = new ListNode(0, head);

        ListNode next = p;


        while (head != null) {
            ListNode tail = next;
            // 查看剩余部分长度是否大于等于 k
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return p.next;
                }
            }
            ListNode nex = tail.next;
            ListNode[] reverse = myReverse(head, tail);
            head = reverse[0];
            tail = reverse[1];
            // 把子链表重新接回原链表
            next.next = head;
            tail.next = nex;
            next = tail;
            head = tail.next;
        }
        return p.next;
    }

    public ListNode[] myReverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

}
