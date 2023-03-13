import java.util.*;

public class coinChangeMinCoins {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= amount; j++){
                if(j == 0)
                    dp[i][j] = 0;
                if(i == 0)
                    dp[i][j] = Integer.MAX_VALUE - 1;
                if(i == 1){
                    if(j % coins[i-1] == 0){
                        dp[i][j] = j / coins[i-1];
                    }else{
                        dp[i][j] = Integer.MAX_VALUE - 1;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= amount; j++){
                if(coins[i-1] <= j)
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i-1]], dp[i-1][j]);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][amount];
    }     
}
