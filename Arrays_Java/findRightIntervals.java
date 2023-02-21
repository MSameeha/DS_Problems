import java.util.*;

public class findRightIntervals {
    public int[] findRightInterval(int[][] intervals) {
        //binary serch for each 
        //nlogn 
        int[] ans = new int[intervals.length];
        TreeMap <Integer, Integer> index_of_start = new TreeMap<>();

        for(int i = 0; i < intervals.length; i++){
            index_of_start.put(intervals[i][0], i);
        }

        for(int i = 0; i < intervals.length; i++){
            int key = index_of_start.ceilingKey(intervals[i][1]);
            ans[i] = (key != null) ? index_of_start.get(key) : -1;
        }

        return ans;
    }
}
