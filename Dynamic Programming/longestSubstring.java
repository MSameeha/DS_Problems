import java.util.*;


public class longestSubstring {
    static int longestCommonSubstr(String S1, String S2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        
        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= m; j++)
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(S1.charAt(i) == S2.charAt(j))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }    
        
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String input2 = sc.nextLine();
        System.out.println(longestCommonSubstr(input, input2, input.length(), input2.length()));
        sc.close();
    }
}
