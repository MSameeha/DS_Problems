package LinkedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class removeNthNodeFromLast {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        for(int i = 1; i <= n; i++){
            fast = fast.next;
        }

        while(fast.next != null){
            fast = fast.next;
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
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode headNew = removeNthFromEnd(head, n);

        while(headNew.next != null){
            System.out.print(headNew.val + " ");
            headNew = headNew.next;
        }System.out.println();
    }
}
// two pointer, 
// tortoise hare method