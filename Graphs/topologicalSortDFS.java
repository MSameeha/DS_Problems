package Graphs;

import java.util.*;

public class topologicalSortDFS {
    static Stack <Integer> st = new Stack<Integer>();
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        boolean[] visited = new boolean[V];
        
        for(int i = 0; i < V; i++){
            visited[i] = false;
        }
        
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, visited, adj);
            }
        }
        
        int[] ans = new int[V];
        int i = 0;
        while(!st.isEmpty()){
            ans[i++] = st.pop();
        }
        return ans;
    }
    
    static void dfs(int i, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[i] = true;
        for(int j: adj.get(i)){
            if(!visited[j]){
                dfs(j, visited, adj);
            }
        }
        st.push(i);
    } 
}