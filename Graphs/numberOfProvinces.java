// https://leetcode.com/problems/number-of-provinces/
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int ans = 0;
        boolean[] visited = new boolean[n];

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, isConnected);
                ans++;
            }
        }
        
        return ans;
    }
    void dfs(int i, boolean[] visited, int[][] isConnected){
        visited[i] = true;

        for(int r = 0; r < isConnected.length; r++){
            if(!visited[r] && isConnected[i][r] == 1){
                dfs(r, visited, isConnected);
            }
        }
    }
}
