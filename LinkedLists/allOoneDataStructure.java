package LinkedLists;

import java.util.HashMap;


class Node{
    String key;
    int freq;
    Node prev;
    Node next;
    Node(String key){
        this.key = key;
        this.freq = 1;
    }
}

class DoublyLinkedList{
    Node head;
    Node tail;
    int list_size;

    DoublyLinkedList(){
        list_size = 0;
        head = new Node("");
        tail = new Node("");

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node){
        node.prev = head;
        node.next = head.next;

        head.next = node;
        node.next.prev = node;
        list_size++;
    }

    public void removeNode(Node node){
        Node prevNode = node.prev;
        Node nextNode = node.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        list_size--;
    }
}

class AllOne {

    HashMap<String, Node> key_node;
    HashMap<Integer, DoublyLinkedList> freq_list;
    int min_freq, max_freq, cur_size;


    public AllOne() {
        freq_list = new HashMap<>();
        key_node = new HashMap<>();
        min_freq = 0;
        max_freq = 0;
        cur_size = 0;        
    }
    
    //increments the frequency 
    //if key doesnt exist add it to freq = 1 DLL
    //check max_frequency as well 
    //Better to use Update function

    public void inc(String key) {
        if(!key_node.containsKey(key)){
            // System.out.println("Exists - " + key_node.get(key));
            Node node = new Node(key);
            DoublyLinkedList curlist = freq_list.getOrDefault(1, new DoublyLinkedList());
            curlist.addNode(node);
            freq_list.put(1, curlist);
            key_node.put(key, node);

            min_freq = 1;

            System.out.println("After inc of " + key + " The max frequency is "+ max_freq);
            if(max_freq < node.freq){
                max_freq++;
            }
            return;
        }

        Node node = key_node.get(key);
        DoublyLinkedList curlist = freq_list.get(node.freq);
        curlist.removeNode(node);

        if(min_freq == node.freq && curlist.list_size == 0){
            min_freq++;
        }

        node.freq++;

        System.out.println("After inc of " + key + " again - The max frequency is "+ max_freq);
        if(max_freq < node.freq){
            max_freq++;
        }
        curlist = freq_list.getOrDefault(node.freq, new DoublyLinkedList());
        curlist.addNode(node);

        freq_list.put(node.freq, curlist);
        key_node.put(key, node);
    }
    
    //decrement frequency 
    //if initial freq = 1 -> remove it from the list 
    //check min_frequency as well

    public void dec(String key) {
        Node node = key_node.get(key);
        DoublyLinkedList curlist = freq_list.get(node.freq);
        curlist.removeNode(node);

        if(max_freq == node.freq){
            max_freq--;
        }

        if(min_freq == node.freq && curlist.list_size == 0){
            min_freq--;
        }
        node.freq--;

        if(min_freq == 0){
            min_freq = checkMinFreq();
        }
        
        curlist = freq_list.getOrDefault(node.freq, new DoublyLinkedList());
        curlist.addNode(node);

        freq_list.put(node.freq, curlist);
        key_node.put(key, node);        
    }
    
    public int checkMinFreq(){
        for(DoublyLinkedList x : freq_list.)
    }

    //return head.next of freq = max_freq
    //

    public String getMaxKey() {
        if(freq_list.get(max_freq) == null) return "";
        return freq_list.get(max_freq).head.next.key;
    }
    
    //return head.next of freq = min_freq
    public String getMinKey() {
        if(freq_list.get(min_freq) == null) return "";
        return freq_list.get(min_freq).head.next.key;
    }
}

public class allOoneDataStructure {
    
}
