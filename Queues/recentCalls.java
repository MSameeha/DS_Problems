package Queues;

import java.util.*;

class RecentCounter {
    Deque<Integer> dq;

    public RecentCounter() {
        dq = new LinkedList<>();
    }
    
    public int ping(int t) {

        System.out.println("Elements initially are: ");
        for(Integer x : this.dq){
            System.out.print(x + " ");
        }System.out.println();

        while(!dq.isEmpty() && t - dq.getFirst() > 3000) {
            System.out.println("Removing " + dq.getFirst());
            dq.removeFirst();
        }
        dq.addLast(t);

        System.out.println("Elements are: ");
        for(Integer x : dq){
            System.out.print(x + " ");
        }System.out.println();

        return dq.size();
    }
    
}

public class recentCalls {
    public static void main(String[] args){
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }
}
