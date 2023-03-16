package LinkedLists;


public class isPalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head, prev;

        //find middle = slow points to middle
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        ListNode middle = prev; //
        //reverse second part of list
        while(){

        }

        System.out.println(slow.val);
        return true;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(10);
        head.next = new ListNode(20);
        head.next.next = new ListNode(30);
        head.next.next.next = new ListNode(40);
        head.next.next.next.next = new ListNode(50);
        head.next.next.next.next = new ListNode(60);

        System.out.println(isPalindrome(head));
    }
}
