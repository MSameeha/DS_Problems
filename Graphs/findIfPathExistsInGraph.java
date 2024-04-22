// https://leetcode.com/problems/find-if-path-exists-in-graph/description/?envType=daily-question&envId=2024-04-21

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(edges.length == 0) return true;

        boolean[] visited = new boolean[n];
        boolean flag = true;

        visited[source] = true;
        while(flag){
            flag = false;
            for(int[] edge: edges){
                if(visited[edge[0]] != visited[edge[1]]){
                    visited[edge[0]] = true;
                    visited[edge[1]] = true;
                    flag = true;
                }
                if(visited[destination] == true) return true;
            }
        }

        return false;
    }
}

/*Dry run

[[0,1],[1,2],[2,0]]
src = 0.   dest = 2
vis[0] = true;
flag = true
    flag = false
    edge - 0,1
        visited[0] != visited[1] //one of them is false
            vis[0] = true
            vis[1] = true
            flag = true
        vis[2] = false - continue
    edge - 1,2
        visited[1] != visited[2] //2 is false
            vis[1] = true
            vis[2] = true
            flag = true
        vis[2] = true returns true
    edge - 2, 0 //if other destination
        //all are visited, flag becomes false

*/