import java.util.*;

public class matrixChainMultiplication {
    static int matrixMultiplication(int n, int arr[])
    {
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return solve(dp, arr, 1, n-1);
    }
    
    static int solve(int[][] dp, int[] arr, int i, int j){
        if(i >= j)
            return dp[i][j] = 0;
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int local_ans = 0, global_ans = Integer.MAX_VALUE;    
            
        for(int k = i; k < j; k++){
            local_ans = solve(dp, arr, i, k) + solve(dp, arr, k+1, j) + (arr[i-1]*arr[k]*arr[j]);
            global_ans = Math.min(global_ans, local_ans);
        }
        
        return dp[i][j] = global_ans;
    }
}
