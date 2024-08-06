//Leetcode - https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){ //edge case 
            return head;
        }
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            if(prev.val == curr.val){
                prev.next = curr.next;
            }else{
                prev = curr; //if removing the curr, prev of next node is prev of current prev. So only change in else 
            }
            curr = curr.next;
        }

        return head;
    }
}
