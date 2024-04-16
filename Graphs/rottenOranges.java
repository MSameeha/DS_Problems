package Graphs;

import java.util.*;

class Solution {
    class Pair{
        int row;
        int col; 
        int time;

        Pair(int r, int c, int t){
            this.row = r;
            this.col = c;
            this.time = t;
        } 
    }
    public int orangesRotting(int[][] grid) {

        //bfs on every rotten orange - level wise
        //put them in a queue along with the time taken to discover them
        //maintain max time variable

        int n = grid.length, m = grid[0].length;

        Queue<Pair> q = new LinkedList <> ();

        int[][] visited = new int[n][m];
        int freshOranges = 0, maxTime = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i, j, 0));
                    visited[i][j] = 2;
                }else{
                    visited[i][j] = 0;
                }
                if(grid[i][j] == 1) freshOranges++;
            }
        }

        int[] drow = {-1, 1, 0, 0};
        int[] dcol = {0, 0, 1, -1};
        int count = 0;
        while(!q.isEmpty()){
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().time;
            maxTime = Math.max(t, maxTime);
            q.remove();

            for(int i = 0; i < 4; i++){
                int rowIndex = r+drow[i], colIndex = c+dcol[i];
                if(rowIndex >= 0 && rowIndex < n && colIndex >= 0 && colIndex < m && grid[rowIndex][colIndex] == 1 && visited[rowIndex][colIndex] == 0){
                    q.add(new Pair(rowIndex, colIndex, t+1));
                    visited[rowIndex][colIndex] = 2;
                    count++;
                }
            }
        }

        if(count != freshOranges) return -1;
        return maxTime;
    }
}