package LinkedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class reverseNodesInEvenLengthsGroup {
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode dummy = head;
        int size = 0;

        while(dummy != null){
            size = size+1;
            int realSize = 0;
            Stack <Integer> st = new Stack<>();
            ListNode curr = dummy;
            while(dummy != null && realSize != size){
                st.push(dummy.val);
                dummy = dummy.next;
                realSize++;
            }
            if(realSize%2 == 1){
                continue;
            }
            while(curr != null && curr != dummy){
                curr.val = st.pop();
                curr = curr.next;
            }
        }
        return head;
    }

        public static void main(String[] args){
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        // head.next.next.next.next = new ListNode(50);
    
        ListNode headNew = reverseEvenLengthGroups(head);

        while(headNew != null){
            System.out.print(headNew.val + " ");
            headNew = headNew.next;
        }System.out.println();
    }
}
