package Queues;

import java.util.*;

class MedianFinder {
    PriorityQueue <Integer> small = new PriorityQueue<>(Comparator.reverseOrder());
    PriorityQueue <Integer> large = new PriorityQueue<>();
    boolean even = true;

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        if(even){
            large.add(num);
            small.add(large.poll());
        }else{
            small.add(num);
            large.add(small.poll());
        }
        even = !even;
    }
    
    public double findMedian() {
        if(even)
            return (small.peek() + large.peek()) / 2.0;
        else
            return small.peek();
    }
}

public class findMedianFromDataStream {
    
}
