// https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int iniColor = image[sr][sc];

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        dfs(image, sr, sc, color, iniColor, ans, dRow, dCol);
        return ans;
    }

    void dfs(int[][] image, int sr, int sc, int newColor, int iniColor, int[][] ans, int[] dRow, int[] dCol){
        ans[sr][sc] = newColor;

        for(int i = 0; i < 4; i++){
            int newRow = sr + dRow[i];
            int newCol = sc + dCol[i];
            if(newRow >= 0 && newRow < image.length && newCol >= 0 && newCol < image[0].length && image[newRow][newCol] == iniColor && ans[newRow][newCol] != newColor){
                dfs(image, newRow, newCol, newColor, iniColor, ans, dRow, dCol);
            }
        }
    }
}