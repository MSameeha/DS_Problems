import java.util.*;

public class findDuplicate {
    public int findDuplicate(int[] nums) {
        for(int x: nums){
            if(x < 0){
                x*=(-1);
            }
            if(nums[x] < 0){
                return x;
            }
            nums[x] *= (-1);
        }
        return -1;
    }
}
