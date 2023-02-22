import java.util.*;

public class shortestBridge {
    public int shortestBridge(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Deque <int[] > q = new ArrayDeque<>();
        int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    visited = dfs(visited, i, j, grid, dir, q);
                    return bfs(q, visited, grid, dir);
                }
            }
        }
        return -1;
    }  

    boolean[][] dfs(boolean[][] visited, int i, int j, int[][] grid, int[][] dir, Deque<int[]> q){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j] || grid[i][j] == 0){
            return visited;
        }
        visited[i][j] = true;
        q.add(new int[]{i,j});
        for(int[] d : dir){
            dfs(visited, i + d[0], j + d[1], grid, dir, q);
        }
        return visited;
    }

    int bfs(Deque<int[]> q, boolean[][] visited, int[][] grid, int[][] dir){
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] pos = q.poll();
                
                for(int[] d: dir){
                    int i = pos[0] + d[0];
                    int j = pos[1] + d[1];

                    if(i < 0 || j < 0 || i >= grid.length || j >= grid.length || visited[i][j] == true) continue;
                    if(grid[i][j] == 1){
                        return level;
                    }
                    visited[i][j] = true;
                    q.offer(new int[]{i, j});                    
                }
            }
            level++;
        }
        return -1;
    }
}
