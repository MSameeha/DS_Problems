package Queues;

import java.util.*;

class MyQueue {
    //To implement queue using one stack we need to do recursive solution which will again make it two stacks
    Stack <Integer> input;
    Stack <Integer> output;

    public MyQueue() {
        input = new Stack<>();
        output = new Stack<>();
    }
    
    public void push(int x) {
        input.push(x);
    }
    
    public int pop() {
        if(output.size() > 0){
            return output.pop();
        }else{
            while(input.size() > 0){
                output.push(input.pop());
            }
        }
        return output.pop();
    }
    
    public int peek() {
        if(output.size() > 0){
            return output.peek();
        }else{
            while(input.size() > 0){
                output.push(input.pop());
            }
        }
        return output.peek();
    }
    
    public boolean empty() {
        return (input.isEmpty() && output.isEmpty());
    }
}


public class implementQueueUsingStacks {
    
}
