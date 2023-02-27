import java.util.*;

public class LevenstheinDistance {
   
    public static int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }

        return helper(word1, word2, n-1, m-1, dp);
    }

    static int helper(String s1, String s2, int i, int j, int[][] dp){
        if(i < 0) return j+1;
        if(j < 0) return i+1;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 0 + helper(s1, s2, i-1, j-1, dp);

        else
            return dp[i][j] = 1 + Math.min(helper(s1, s2, i-1, j-1, dp), Math.min(helper(s1, s2, i-1, j, dp), helper(s1, s2, i, j-1, dp)));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.nextLine();
        String word2 = sc.nextLine();

        System.out.println(minDistance(word1, word2));
        sc.close();
    }
}
