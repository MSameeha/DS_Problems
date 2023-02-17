package Queues;

import java.util.*;

class MyCircularDeque {

    int[] buffer;
    int capacity, front, rear, size;

    public MyCircularDeque(int k) {
        buffer = new int[k];
        capacity = k;
        size = 0;
        front = k-1;
        rear = 0;
    }
    
    public boolean insertFront(int value) {
        if(size == capacity) return false;

        buffer[front] = value;
        front = (front - 1 + capacity) % capacity;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(capacity == size) return false;
        
        buffer[rear] = value;
        rear = (rear + 1) % capacity;
        size++;

        return true;
    }
    
    public boolean deleteFront() {
        if(size == 0) return false;

        front = (front+1) % capacity;
        size--;

        return true;
    }
    
    public boolean deleteLast() {
        if(size == 0) return false;

        rear = (rear - 1 + capacity) % capacity;
        size--;
        return true;
    }
    
    public int getFront() {
        if(size == 0) return -1;

        return buffer[(front+1)%capacity];
    }
    
    public int getRear() {
        if(size == 0) return -1;

        return buffer[(rear-1+capacity)%capacity];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

public class designCircularDeque {
    
}
