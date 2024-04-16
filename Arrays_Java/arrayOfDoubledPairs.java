import java.util.*;

// Leetcode: https://leetcode.com/problems/array-of-doubled-pairs/description/

public class arrayOfDoubledPairs {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> freq = new TreeMap<>();

        for(int x: arr){
            freq.put(x, freq.getOrDefault(x, 0) + 1);
        }

        for(int x: freq.keySet()){
            if(freq.get(x) == 0) continue;
            int want = (x < 0)? x/2 : 2*x;
            if((x < 0 && x % 2  != 0) || freq.get(x) > freq.getOrDefault(want, 0)){
                return false;
            }
            freq.put(want, freq.get(want) - freq.get(x));
        }

        return true;
    }
}
