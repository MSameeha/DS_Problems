import java.util.*;

public class rod_cutting {
    public int cutRod(int price[], int n) {
        //code here
        int[][] dp = new int[n+1][n+1];
        
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(i <= j){
                    int val1 = price[i-1] + dp[i][j - i];
                    int val2 = dp[i-1][j];
                    dp[i][j] = Math.max(val1, val2);
                }else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[n][n];
    }
       
}
