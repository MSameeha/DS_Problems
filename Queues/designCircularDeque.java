package Queues;

import java.util.*;

class MyCircularDeque {

    int size;
    int[] data;
    int rear, front;

    public MyCircularDeque(int k) {
        data = new int[k];
        size = 0;
        rear = k-1;
        front = 0;
    }
    
    public boolean insertFront(int value) {
        if(data.length == size) return false;
        data[front] = value;
        front = (front + 1) % data.length;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(data.length == size) return false;
        data[rear] = value;
        rear = (rear - 1 + data.length) % data.length;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        
    }
    
    public boolean deleteLast() {
        
    }
    
    public int getFront() {
        if(size == 0) return -1;
        return data[(front - 1 + data.length) % data.length];
    }
    
    public int getRear() {
        if(size == 0) return -1;
        return data[()]
    }
    
    public boolean isEmpty() {
        
    }
    
    public boolean isFull() {
        
    }
}

public class designCircularDeque {
    
}
