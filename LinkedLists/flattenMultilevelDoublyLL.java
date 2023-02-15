package LinkedLists;

import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

public class flattenMultilevelDoublyLL {
    public static Node flatten(Node head) {
        Node curr = head, tail = head;
        Stack<Node> st = new Stack<>();

        while(curr != null){
            if(curr.child != null){
                if(curr.next != null){
                    st.push(curr.next);
                    curr.next.prev = null;
                }
                curr.next = curr.child;
                curr.next.prev = curr;
                curr.child = null;
            }
            tail = curr;
            curr = curr.next;
        }

        while(!st.isEmpty()){
            curr = st.pop();
            tail.next = curr;
            curr.prev = tail;

            while(curr != null){
                tail = curr;
                curr = curr.next;
            }
        }
        return head;
    }   
}
