package LeetCode;/*  2. Add Two Numbers
 *   You are given two non-empty linked lists representing two non-negative integers.
 *   The digits are stored in reverse order, and each of their nodes contains a single digit.
 *   Add the two numbers and return the sum as a linked list.
 *   You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *   给你两个 非空 的链表，表示两个非负的整数。
 *   它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *   请你将两个数相加，并以相同形式返回一个表示和的链表。
 *   你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *   https://leetcode-cn.com/problems/add-two-numbers/
 * */

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode r = null,p=new ListNode();
        int up=0;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum=up+v1+v2;
            if(sum>=10){
                up=1;
                sum-=10;
            }else {
                up=0;
            }
            p.next=new ListNode(sum);
            p=p.next;
            if(r==null){
                r=p;
            }
            if(l1!=null){
                l1=l1.next;
            }
            if(l2!=null){
                l2=l2.next;
            }
        }
        if(up>0){
            p.next=new ListNode(1);
        }
        return r;
    }

    public static void main(String[] args) {
        AddTwoNumbers2 addTwoNumbers=new AddTwoNumbers2();
    }

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
}


