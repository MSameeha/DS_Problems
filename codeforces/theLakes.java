package codeforces;

import java.util.*;

public class theLakes {

    static class Pair {
        int first, second;
        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] mat = new int[n][m];

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            boolean[][] visited = new boolean[n][m];
            int[] dx = {1, -1, 0, 0};
            int[] dy = {0, 0, 1, -1};
            int curr = 0, ans = 0;

            for(int i = 0; i < n; i++)
                for(int j = 0; j < m; j++)
                    visited[i][j] = false;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(visited[i][j] == false && mat[i][j] != 0) {
                        Queue <Pair> bfs = new LinkedList<Pair>();
                        bfs.add(new Pair(i,j));
                        curr = 0;

                        while(!bfs.isEmpty()){
                            Pair pair = bfs.remove();
                            visited[pair.first][pair.second] = true;
                            curr += mat[pair.first][pair.second];

                            for(int k = 0; k < 4; k++){
                                int x = pair.first + dx[k];
                                int y = pair.second + dy[k];

                                if(x >= 0 && x < n && y >= 0 && y < m){
                                    if(visited[x][y] == false && mat[x][y] != 0){
                                        bfs.add(new Pair(x,y));
                                        visited[x][y] = true;
                                    }
                                }
                            }
                            System.out.println(pair.first + " " + pair.second);
                        }
                    }
                    ans = Math.max(ans, curr);
                }
            }
            System.out.println(ans);
        }
        sc.close();
    } 
}
