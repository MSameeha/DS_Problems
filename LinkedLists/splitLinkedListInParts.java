package LinkedLists;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class splitLinkedListInParts {

    public static ListNode[] splitListToParts(ListNode head, int k) {

        ListNode[] ans;

        //get the size
        int size = 0;
        ListNode dummy = head;
        while(dummy != null){
            dummy = dummy.next;
            size++;
        }

        //number of parts = k

        //average number of elements in each part = size/k

        //the first (size%k) parts will have 1 extra element
        int extra_element_parts = size%k;
        int size_of_parts = size/k;

        ans = new ListNode[k];

        ListNode node = head, prev = null;
        for(int i = 0; node != null && i < k; i++, extra_element_parts--){
            ans[i] = node;
            for(int j = 0; j < size_of_parts + (extra_element_parts > 0 ? 1: 0); j++){
                prev = node;
                node = node.next;
            }
            prev.next = null;
        }
        return ans;
        // ListNode node = new ListNode();
        // node = head;
        // int i = 1;
        // for(i = 1; i <= extra_element_parts; i++, k--){
        //     int index = 0;
        //     ans[i-1] = node; 
        //     ListNode prev = node;
        //     while(index != (size_of_parts+1)){
        //         prev = node;
        //         node = node.next;
        //         index++;
        //     }
        //     prev.next = null;
        // }
        // i--;
        // for(; k > 0; k--, i++){
        //     int index = 0;
        //     ans[i-1] = node; 
        //     ListNode prev = node;
        //     while(index != (size_of_parts)){
        //         prev = node;
        //         node = node.next;
        //         index++;
        //     }
        //     prev.next = null;            
        // }

        // return ans;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
    
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ListNode[] heads = splitListToParts(head, n);

        for(ListNode headNew : heads){
            while(headNew != null){
                System.out.print(headNew.val + " ");
                headNew = headNew.next;
            }System.out.println("----------------------------------");
        }
    }
}
