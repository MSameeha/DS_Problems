import java.util.*;

public class KnapsackBounded {
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
        int[][] dp = new int[n+1][W+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= W; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(wt[i-1] <= j){
                    int val1 = val[i-1] + dp[i-1][j - wt[i-1]];
                    int val2 = dp[i-1][j];
                    dp[i][j] = Math.max(val1, val2);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][W]; 
    }     
}
