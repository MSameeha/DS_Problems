import java.util.*;

public class arrayPartition {
    public int arrayPairSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for(int i = 0; i < n; i+=2){
            ans += nums[i];
        }
        return ans;
    }
}
