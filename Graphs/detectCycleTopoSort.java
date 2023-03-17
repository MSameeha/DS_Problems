package Graphs;

import java.util.*;

public class detectCycleTopoSort {
    static Stack <Integer> st = new Stack<Integer>();
    static boolean hasCycle(int V, ArrayList<ArrayList<Integer>> adj) 
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
        
        HashMap <Integer, Integer> map = new HashMap<>();
        int i = 0;
        while(!st.isEmpty()){
            map.put(st.pop(), i++);
        }

        for(int j = 0; j < V; j++){
            for(Integer child : adj.get(j)){
                if(map.get(child) > map.get(j)){
                    return true;
                }
            }
        }
        return false;
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
