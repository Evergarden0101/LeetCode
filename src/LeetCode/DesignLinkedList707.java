package LeetCode;
/*  707. Design Linked List
 *   https://leetcode-cn.com/problems/design-linked-list/
 * */

public class DesignLinkedList707 {
    class Node {
        int val;
        Node next;
        Node prev;

        public Node() {
            this.val = 0;
            this.next = null;
            this.prev = null;
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        public Node(int val, Node prev) {
            this.val = val;
            this.next = null;
            this.prev = prev;
        }

        public Node(int val, Node prev, Node next) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }

    }

    /**
     * Initialize your data structure here.
     */

    Node head;
    Node end;
    int size;


    public DesignLinkedList707() {
        head = new Node();
        end = head;
        size=0;
    }


    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        int cou = -1;
        Node p = head;
        while (cou < index-1 && p.next != null) {
            p = p.next;
            cou++;
        }
        if (cou == index-1 && p.next != null) {
            return p.next.val;
        } else return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        if(head.next!=null){
            Node p = new Node(val);
            p.next=head.next;
            p.next.prev = p;
            head.next = p;
        }else {
            Node p = new Node(val);
            head.next = p;
        }
        while (end.next != null) end = end.next;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        if(end==head){
            end.next=new Node(val);
            end=end.next;
        }else {
            end.next = new Node(val, end);
            end = end.next;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index==size){
            addAtTail(val);
            return;
        }else if(index==0){
            addAtHead(val);
            return;
        }
        int cou = -1;
        Node p = head;
        while (cou < index - 1 && p.next != null) {
            p = p.next;
            cou++;
        }
        if (cou == index - 1 && p.next != null) {
            Node add = new Node(val, p, p.next);
            p.next.prev = add;
            p.next = add;
        }
        size++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(index>=size||index<0)   return;
        int cou = -1;
        Node p = head;
        while (cou < index && p != null) {
            p = p.next;
            cou++;
        }
        if (cou == index  && p != null) {
            if(p.next==null&&p.prev==null){
                head.next=null;
                end=head;
            }
            else if(p.prev==null){
                p.next.prev=null;
                head.next=p.next;
            }
            else if(p.next==null){
                p.prev.next=null;
                end=p.prev;
            }
            else {
                p.next.prev=p.prev;
                p.prev.next=p.next;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        /*
        *   ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex"
        *   ,"addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
        *   [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
        * */
        DesignLinkedList707 linkedList = new DesignLinkedList707();
        linkedList.addAtHead(7);
        System.out.println(linkedList.head.next.val);
        linkedList.addAtHead(2);
        System.out.println(linkedList.head.next.val);
        linkedList.addAtHead(1);
        System.out.println(linkedList.head.next.val);
        System.out.println();

        linkedList.addAtIndex(3,0);
        System.out.println(linkedList.head.next.val);
        System.out.println(linkedList.head.next.next.val);
        System.out.println(linkedList.end.val);
        System.out.println();


        linkedList.deleteAtIndex(2);
        System.out.println(linkedList.head.next.val);
        System.out.println(linkedList.head.next.next.val);
        System.out.println(linkedList.end.val);
        System.out.println();

        linkedList.addAtHead(6);
        System.out.println(linkedList.head.next.val);
        System.out.println();

        linkedList.addAtTail(4);
        System.out.println(linkedList.end.val);
        System.out.println();

        System.out.println(linkedList.get(4));
        System.out.println();

        linkedList.addAtHead(4);
        System.out.println(linkedList.head.next.val);
        System.out.println();

        linkedList.addAtIndex(5,0);
        System.out.println(linkedList.head.next.val);
        System.out.println(linkedList.head.next.next.val);
        System.out.println(linkedList.end.val);
        System.out.println();

        linkedList.addAtHead(6);
        System.out.println(linkedList.head.next.val);
        System.out.println();
    }
}


