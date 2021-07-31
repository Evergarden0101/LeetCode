package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/*  142. Linked List Cycle II
 *   Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *   There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 *   Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 *   Notice that you should not modify the linked list.
 *   给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *   为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 *   如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *   说明：不允许修改给定的链表。
 *   进阶：
 *   你是否可以使用 O(1) 空间解决此题？
 *   https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * */
public class LinkedListCycleII142 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if(head==null)  return null;
        HashSet<ListNode> hash=new HashSet<>();
        while(head.next!=null){
            if(hash.contains(head)){
                return head;
            }
            hash.add(head);
            head=head.next;
        }
        return null;
    }
}
