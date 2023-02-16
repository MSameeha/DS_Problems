package Queues;

import java.util.*;

public class countSubarrayWithFixedBounds {
    public static long countSubarrays(int[] nums, int minK, int maxK) {
        int jbad = -1, jmin = -1, jmax = -1;
        long res = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] < minK || nums[i] > maxK){
                jbad = i;
            }
            if(nums[i] == minK){
                jmin = i;
            }
            if(nums[i] == maxK){
                jmax = i;
            }

            if(jmin != -1 && jmax != -1)
            res += Math.max(0, Math.min(jmax, jmin) - jbad);
        }

        return res;
    }    
}
