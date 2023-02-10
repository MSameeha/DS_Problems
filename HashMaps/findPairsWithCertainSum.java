package HashMaps;

import java.util.*;

class FindSumPairs {

    int[] nums1, nums2;
    HashMap < Integer, Integer> freq = new HashMap<>();
    
    public FindSumPairs(int[] nums1, int[] nums2) {
        //constructor
        this.nums1 = nums1;
        this.nums2 = nums2;
        for(int x : nums2){
            freq.put(x, freq.getOrDefault(x, 0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        freq.put(nums2[index], freq.get(nums2[index]-1));
        nums2[index] = val;
        freq.put(nums2[index], freq.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int ans = 0; 
        for(int x : nums1){
            if(freq.containsKey(tot-x)){
                ans += freq.get(tot-x);
            }
        }
        return ans;
    }
}

public class findPairsWithCertainSum {
    
}
