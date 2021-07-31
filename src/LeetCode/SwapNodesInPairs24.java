package LeetCode;

/*  24. Swap Nodes in Pairs
*   Given a linked list, swap every two adjacent nodes and return its head.
*   You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
*   Constraints:
    The number of nodes in the list is in the range [0, 100].
    0 <= Node.val <= 100
*   给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
*   你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
*   提示：
    链表中节点的数目在范围 [0, 100] 内
    0 <= Node.val <= 100
*   https://leetcode-cn.com/problems/swap-nodes-in-pairs/
* */
public class SwapNodesInPairs24 {
    public static class ListNode {
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

    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode p = new ListNode(0,head);
        head = head.next;
        while (p.next != null && p.next.next != null) {
            ListNode node1 = p.next;
            ListNode node2 = p.next.next;
            node1.next=node2.next;
            node2.next=node1;
            p.next=node2;
            p=node1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode p = head.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        SwapNodesInPairs24 swapNodesInPairs24 = new SwapNodesInPairs24();
        head = swapNodesInPairs24.swapPairs(head);
        while (head != null) {
            System.out.println(head.val);
            head=head.next;
        }
    }
}
