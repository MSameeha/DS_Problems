import java.util.*;

public class equalSumSubset {
    static boolean subsetSum(int[] nums, int sum){
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum +1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= sum; j++){
                if(i == 0) //empty array
                    dp[i][j] = false;
                if(j == 0) //sum = 0, always possible
                    dp[i][j] = true;
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= sum; j++){
                if(nums[i-1] <= j){
                    dp[i][j] = dp[i-1][j - nums[i-1]] || dp[i-1][j];
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];

    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int x: nums)
            sum += x;
        if(sum % 2 != 0) return false;

        return subsetSum(nums, sum/2);   
    }
}
