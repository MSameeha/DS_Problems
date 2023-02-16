package LinkedLists;

import java.util.*;

class Node{
    Node prev, next;
    int key, value, frequency;
    Node(int key, int value){
        this.key = key;
        this.value = value;
        this.frequency = 1;
    }
}

class DoublyLinkedList {
    int list_size;
    Node head;
    Node tail;
    public DoublyLinkedList(){
        //initialize size, head, tail and head tail link
        list_size = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public void addNode(Node node){
        //add to the head, increment size
        // Node newNode = new Node(0, 0);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        list_size++;
    }

    public void removeNode(Node node){
        //remove tail.prev and decrease size
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        list_size--;
    }
}

public class LFUCache {
   
    HashMap<Integer, DoublyLinkedList> freq_list;
    HashMap<Integer, Node> key_node;
    int capacity, last_frequency, curSize;
    
    public LFUCache(int capacity) {
        freq_list = new HashMap<>();
        key_node = new HashMap<>();
        this.capacity = capacity;
        last_frequency = 0;
        curSize = 0;
    }
    
    public int get(int key) {
        //if contains -> get the node and update its frequency
        //else -1
        //have an update function
        if(!key_node.containsKey(key)) return -1;
        Node node = key_node.get(key);
        updateNode(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        //put the value in head of freq=1 list 
        //if capacity == key_node.size() then, go to last_frequency list, if it has >1 nodes -> remove the node just before tail i.e Least recently used
    
        if(key_node.containsKey(key)){
            //get the node
            Node node = key_node.get(key);
            //update its value 
            node.value = value;
            //call updateNode()coz key ka frequency will increase
            updateNode(node);
            return;
        }
        if(curSize == capacity){
            //remove the node go to last_frequency list, if it has >1 nodes -> remove the node just before tail i.e Least recently used
            //also remove it from key_node
            DoublyLinkedList last_freq_list = freq_list.get(last_frequency);
            Node node = last_freq_list.tail.prev;
            key_node.remove(node.key);
            last_freq_list.removeNode(node);
            curSize--;
        }
        curSize++;
        //last_frequency = 1, create a new node with key value pair
        //if a list in frequency =1 key exist, use that else new DLL
        //add the new node using addnode function for the list(on the list)
        //freq_list put the key and DLL
        //key_node put key and the node
        last_frequency = 1;
        DoublyLinkedList newList = freq_list.getOrDefault(last_frequency, new DoublyLinkedList());
        Node node = new Node(key, value);
        newList.addNode(node);
        freq_list.put(last_frequency, newList);
        key_node.put(key, node);
    }

    void updateNode(Node node){
        //get the frequency of this node
        //create a copy of the DLL of the frequency = frequency of node
        //remove node from the frequency DLL
        int curFreq = node.frequency;
        DoublyLinkedList currList = freq_list.get(curFreq);
        currList.removeNode(node);

        //if after removing the list became empty and its freq = last_frequency 
        //increment last_frequency
        if(last_frequency == curFreq && currList.list_size == 0){
            last_frequency++;
        }
        //create new DLL if doesnt already exist, increment node's frequency and add to new list
        //put that in key_node map as well -> zaroorat nahi hai coz node address remains same 

        node.frequency++;
        DoublyLinkedList newList = freq_list.getOrDefault(node.frequency, new DoublyLinkedList());
        newList.addNode(node);
        //FREQUENCY KAISE UPDATE KARNA HAI FROM NODE

        freq_list.put(node.frequency, newList);
    }
}
