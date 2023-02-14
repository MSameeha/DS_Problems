package LinkedLists;

import java.util.*;
class MyLinkedList {
    int length;
    Node head;
    class Node{
        int val;
        Node next;
        Node(int x){
            this.val = x;
        }
    }

    public MyLinkedList() {
        this.length = 0;
        this.head = null; 
    }
    
    public int get(int index) {
        if(index >= this.length || index < 0){
            return -1;
        }
        int traverse = 0;
        Node dummy = head;
        while(traverse != index){
            dummy = dummy.next;
            traverse++;
        }
        return dummy.val;
    }
    
    public void addAtHead(int val) {
        Node prev = new Node(val);
        prev.next = this.head;
        this.head = prev;
        this.length++;
    }
    
    public void addAtTail(int val) {
        if(this.length == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        Node dummy = head;
        while(dummy.next != null){
            dummy = dummy.next;
        }
        dummy.next = node;
        node.next = null;
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.length){
            return;
        }else if(index == this.length){
            addAtTail(val);
            return;
        }else if(index == 0){
            addAtHead(val);
            return;
        }
        Node node = new Node(val);
        int traverse = 0;
        Node dummy = head;

        while(traverse != (index-1)){
            dummy = dummy.next;
            traverse++;
        }
        node.next = dummy.next;
        dummy.next = node;
        this.length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= this.length){
            return;
        }
        if(index == 0){
            head = head.next;
            this.length--;
            return;
        }
        int traverse = 0;
        Node dummy = head;
        while(traverse != index-1){
            dummy = dummy.next;
            traverse++;
        }
        dummy.next = dummy.next.next;
        this.length--;  
    }
}