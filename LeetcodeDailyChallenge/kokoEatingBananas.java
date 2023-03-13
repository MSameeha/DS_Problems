package LeetcodeDailyChallenge;

import java.util.*;

public class kokoEatingBananas {

    static boolean canEatInMid(int[] piles, int h, int time){
        int hours = 0;
        for(int x : piles){
            hours += x / time;
            if(x % time != 0) hours++;
        }
        return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(canEatInMid(piles, h, mid))
                high = mid-1;
            else
                low = mid+1;
        }
        return low;
    }
}
