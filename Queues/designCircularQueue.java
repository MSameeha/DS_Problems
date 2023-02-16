package Queues;

import java.util.*;

class MyCircularQueue {

    int[] data;
    int size, front, rear;
    
    public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
        front = 0;
        rear = -1;
    }
    
    public boolean enQueue(int value) {
        //push element here 
        if(isFull() == true) return false;

        if(rear == size-1){
            rear = -1;
        }
        data[++rear] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        //remove elements
        if(front == rear){
            //only one element
            front = 0;
            rear = -1;
        }else{
            if(front == size-1){
                front = 0;
            }else{
                front++;
            }
        }
        return true;
    }
    
    public int Front() {
        if(isEmpty()) return -1;
        return data[front];
    }
    
    public int Rear() {
        if(isEmpty()) return -1;
        return data[rear];
    }
    
    public boolean isEmpty() {
        if(front == 0 && rear == -1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
        if(front == 0 && rear == size-1){
            return true;
        }else if(front != 0 && rear == front-1){
            return true;
        }
        return false;
    }
}


public class designCircularQueue {
    
}
