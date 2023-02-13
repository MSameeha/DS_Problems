package LinkedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class deleteMiddleOfLinkedList {
    public static ListNode deleteMiddle(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy, slow = dummy;

        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }    

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next.next = new ListNode(60);
    
        ListNode headNew = deleteMiddle(head);

        while(headNew != null){
            System.out.print(headNew.val + " ");
            headNew = headNew.next;
        }System.out.println();
    }

}
