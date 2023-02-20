package Queues;

import java.util.*;

class MedianFinder {

    PriorityQueue<Integer> pq;
    //increasing order
    int n ;

    public MedianFinder() {
        pq = new PriorityQueue<>();
        n = 0;
    }
    
    public void addNum(int num) {
        pq.add(num); n++;
    }
    
    public double findMedian() {
        if(n % 2 == 0){
            return pq.
        }
    }
}


public class medianFromDataStream {
    
}
