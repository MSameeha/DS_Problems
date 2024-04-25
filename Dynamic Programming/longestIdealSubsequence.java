// https://leetcode.com/problems/longest-ideal-subsequence/description/?envType=daily-question&envId=2024-04-25


class Solution {
    public int longestIdealString(String s, int k) {
        //traverse from end, add +k, -k char length for every character

        int dp[] = new int[27];
        int n = s.length(), ans = 0;

        for(int i = n-1; i >= 0; i--){
            char cc = s.charAt(i);
            int index = cc - 'a';

            int leftMost = Math.max(index-k, 0);
            int rightMost = Math.min(index+k, 26);
            int max = 0;

            for(int j = leftMost; j <= rightMost; j++){
                max = Math.max(dp[j], max);
            }

            dp[index] = max + 1;
            ans = Math.max(dp[index], ans);
        }

        return ans;
    }

}