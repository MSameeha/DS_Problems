import java.util.*;

public class missingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for(int x: nums){
            if(x < n){
                nums[x] *= (-1); 
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                return i;
            }
        }

        return n;
    }
}
