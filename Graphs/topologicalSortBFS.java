package Graphs;

import java.util.*;

public class topologicalSortBFS {
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        //topo sort through BFS
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            indegree[i] = 0;    
        }
        
        for(ArrayList<Integer> neighbor: adj){
            for(Integer x: neighbor){
                indegree[x]++;
            }
        }
        
        Queue <Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0)
                q.add(i);
        }

        int[] ans = new int[V];
        int index = 0;

        while(!q.isEmpty()){
            int i = q.poll();
            ans[index++] = i;
            for(int x: adj.get(i)){
                indegree[x]--;
                if(indegree[x] == 0)
                    q.add(x);
            }
        }
        return ans;
    }
        
}
