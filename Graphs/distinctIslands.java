class Solution {

    class Pair{
        int row;
        int col;
        Pair(int r, int c){
            this.row = r;
            this.col = c;
        }
    }

	void bfs(int rr, int cc, int[][] visited, char[][] grid){
		visited[rr][cc] = 1;

        int n = grid.length;
		int m = grid[0].length;

		Queue <Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(rr, cc));

		while(!q.isEmpty()){
			int row = q.peek().row;
            int col = q.peek().col;
			q.remove();
			
            int[] dRow = {-1, 1, 0, 0};
            int[] dCol = {0, 0, -1, 1};

            for(int i = 0; i < 4; i++){
                int r = row + dRow[i];
                int c = col + dCol[i];

                if(r >= 0 && r < n && c >= 0 && c < m && visited[r][c] == 0 && grid[r][c] == '1'){
                    visited[r][c] = 1;
                    q.add(new Pair(r, c));
                }
            }
		}
	}


    public int numIslands(char[][] grid) {
        int island = 0;

        int n = grid.length;
		int m = grid[0].length;

		int[][] visited = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(visited[i][j] == 0 && grid[i][j] == '1'){
					island++;
                    bfs(i, j, visited, grid);
				}
			}
		}

		return island;
    }
}