import java.util.*;

public class minTimeToCompleteTrips{

    static long midIsTime(int[] time, long givenTime){
        long sum = 0;
        for(int x : time){
            sum += (long) givenTime*1.0 / x;
        }
        return sum;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1;
        long high = (long)1e14;

        while(low < high){
            long mid = low + (high-low)/2;
            if(midIsTime(time, mid) >= (long)totalTrips){
                high = mid;
            }else{
                low = mid+1;
            }
        }
        return low;
    }
}