package LeetcodeDailyChallenge;

import java.util.*;

public class minimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int min = Integer.MAX_VALUE;

        for(int x : nums){
            if(x % 2 == 1) x = 2*x;
            pq.offer(-x);
            min = Math.min(min, x);
        }
        int diff = Integer.MAX_VALUE;
        while(true){
            int max = -pq.poll();
            diff = Math.min(diff, (max-min));
            if(max % 2 == 1) break;
            min = Math.min(min, max/2);
            pq.offer(-max/2);
        }
        return diff;
    }
}
