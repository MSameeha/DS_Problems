import java.util.*;

public class numberofClosedIslands {
    public int closedIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, closed_islands = 0;

        for(int i = 1; i < n-1; i++){
            for(int j = 1; j < m-1; j++){
                if(isClosed(i, j, n, m, grid)){
                    closed_islands++;
                }
            }
        }
        return closed_islands;
    }

    static boolean isClosed(int i, int j, int rows, int col, int[][] grid){
        if(grid[i][j] == -1 || grid[i][j] == 1) return true;

        if(i == 0 || j == 0 || i == rows-1 || j == col-1) return false;
        grid[i][j] = -1;

        return isClosed(i+1, j, rows, col, grid) && isClosed(i-1, j, rows, col, grid) && isClosed(i, j+1, rows, col, grid) && isClosed(i, j-1, rows, col, grid);
    }
}
