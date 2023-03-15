package Graphs;

import java.util.*;
import java.io.*;

public class allTopologicalSorts {
    
    static List<int[]> ans = new ArrayList<>();

    static void topoSort(int V, ArrayList<ArrayList<Integer>> adj, Stack <Integer> path, int[] indegree, boolean[] visited) 
    {
   
        for(int i = 0; i < V; i++){
            if(indegree[i] == 0 && !visited[i]){
                path.add(i);
                visited[i] = true;
                for(int x: adj.get(i)){
                    indegree[x]--;
                }

                topoSort(V, adj, path, indegree, visited);

                visited[i] = false;
                path.remove(path.size()-1);

                for(int x: adj.get(i)){
                    indegree[x]++;
                }
            }
        }
        // System.out.println("Hey  " + path.size());
        if(path.size() == V){
            System.out.println(path);
        }
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            Stack <Integer> path = new Stack<>();
            int[] indegree = new int[nov];
            boolean[] visited = new boolean[nov];
        
            //calculate indegree of every node
            for(int i = 0; i < nov; i++){
                indegree[i] = 0;    
            }
            
            for(ArrayList<Integer> neighbor: list){
                for(Integer x: neighbor){
                    indegree[x]++;
                }
            }

            allTopologicalSorts obj = new allTopologicalSorts();
            obj.topoSort(nov, list, path, indegree, visited);
        }
    }
    
}
