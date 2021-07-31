package LeetCode;

import java.util.HashMap;
import java.util.HashSet;

/*  160. Intersection of Two Linked Lists
*   Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
*   If the two linked lists have no intersection at all, return null.
*   Note that the linked lists must retain their original structure after the function returns.
*   Custom Judge:
    The inputs to the judge are given as follows (your program is not given these inputs):
    intersectVal - The value of the node where the intersection occurs. This is 0 if there is no intersected node.
    listA - The first linked list.
    listB - The second linked list.
    skipA - The number of nodes to skip ahead in listA (starting from the head) to get to the intersected node.
    skipB - The number of nodes to skip ahead in listB (starting from the head) to get to the intersected node.
    The judge will then create the linked structure based on these inputs and pass the two heads, headA and headB to your program. If you correctly return the intersected node, then your solution will be accepted.
*   给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。
*   如果两个链表没有交点，返回 null 。
*   题目数据 保证 整个链式结构中不存在环。
*   注意，函数返回结果后，链表必须 保持其原始结构 。
*   提示：
    listA 中节点数目为 m
    listB 中节点数目为 n
    0 <= m, n <= 3 * 104
    1 <= Node.val <= 105
    0 <= skipA <= m
    0 <= skipB <= n
    如果 listA 和 listB 没有交点，intersectVal 为 0
    如果 listA 和 listB 有交点，intersectVal == listA[skipA + 1] == listB[skipB + 1]
 
    进阶：你能否设计一个时间复杂度 O(n) 、仅用 O(1) 内存的解决方案？
*   https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
* */
public class IntersectionOfTwoLinkedLists160 {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        HashSet<ListNode> hash = new HashSet<>();
        while (headA != null || headB != null) {
            if (headA != null) {
                if (hash.contains(headA)) return headA;
                hash.add(headA);
                headA = headA.next;
            }
            if (headB != null) {
                if (hash.contains(headB)) return headB;
                hash.add(headB);
                headB = headB.next;
            }
        }
        return null;

        /*  双指针两个表各走一次，第二轮在连接点相遇
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
         */
    }
}
