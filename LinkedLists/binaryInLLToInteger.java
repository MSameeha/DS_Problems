package LinkedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class binaryInLLToInteger {
    public static int getDecimalValue(ListNode head) {
        String ans = "";
        while(head != null){
            ans += head.val;
            head = head.next;
        }
        return Integer.parseInt(ans, 2);
    }   

        public static void main(String[] args){
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(getDecimalValue(head));
    }
}
