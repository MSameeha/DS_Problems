// https://leetcode.com/problems/find-all-groups-of-farmland/?envType=daily-question&envId=2024-04-20

class Solution {
    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;

        List<int[]> result = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        int[] dRow = {-1, 1, 0, 0};
        int[] dCol = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(land[i][j] == 1 && !visited[i][j]){
                    int[] farmland = {i, j, i, j}; //start and end
                    q.offer(new int[]{i, j});

                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        int newRow = curr[0];
                        int newCol = curr[1];

                        for(int k = 0; k < 4; k++){
                            int new_row = newRow + dRow[k];
                            int new_col = newCol + dCol[k];

                            if(new_row >= 0 && new_row < n && new_col >= 0 && new_col < m && land[new_row][new_col] == 1 && !visited[new_row][new_col]){
                                q.offer(new int[]{new_row, new_col});
                                visited[new_row][new_col] = true;
                                farmland[2] = Math.max(farmland[2], new_row);
                                farmland[3] = Math.max(farmland[3], new_col);
                            }
                        }
                    }

                    result.add(farmland);
                }
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}