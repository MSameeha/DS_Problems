package Graphs;

import java.util.*;

public class allTopologicalSorts {
    
    static List<int[]> ans = new ArrayList<>();

    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj, Queue <Integer> path, int[] order, int[] indegree, boolean[] visited) 
    {
        
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0 && !visited[i]){
                
                path.add(i);
                visited[i] = true;
                for(int x: adj.get(i)){
                    indegree[x]--;
                }

                topoSort(V, adj, path, order, indegree, visited);

                visited[i] = false;
                path.remove(path.size()-1);

                for(int x: adj.get(i)){
                    indegree[x]++;
                }
            }
        }

        if(path.size() == V){
            System.out.println(path);
        }
        return;
        // int[] ans = new int[V];
        // int index = 0;

        // while(!q.isEmpty()){
        //     int i = q.poll();
        //     ans[index++] = i;
        //     for(int x: adj.get(i)){
        //         indegree[x]--;
        //         if(indegree[x] == 0)
        //             q.add(x);
        //     }
        // }
        // return ans;
    }
        
}
