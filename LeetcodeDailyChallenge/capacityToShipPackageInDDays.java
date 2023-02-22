package LeetcodeDailyChallenge;

import java.util.*;

public class capacityToShipPackageInDDays {
    private static boolean decreaseCap(int capacity, int[] weights, int days){
        int copy_cap = capacity;
        int d = 1; //days it will take with capacity = capacity
        for(int x : weights){
            if(capacity >= x){
                capacity -= x;
            }else{
                d++;
                capacity = copy_cap;
                capacity -= x;
            }
        }
        return (d <= days);
    }
    public int shipWithinDays(int[] weights, int days) {
        int max_element = 0, sum = 0;
        for(int x: weights){
            max_element = Math.max(max_element, x);
            sum += x;
        }
        int low = max_element, high = sum, mid = 0;

        while(low < high){
            mid = low + (high-low)/2;
            if(decreaseCap(mid, weights, days)){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}
