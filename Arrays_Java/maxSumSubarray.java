import java.util.*;

class maxSumSubarray{
    public int maxSubArray(int[] nums) {
        int maxo = nums[0], sum = 0;
        
        for(int x : nums){
            sum += x;
            maxo = Math.max(sum, maxo);
            if(sum < 0){
                sum = 0;
            }
        }

        return maxo;
    }
}