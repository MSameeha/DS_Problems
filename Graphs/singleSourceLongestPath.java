package Graphs;

import java.util.*;


public class singleSourceLongestPath {
    static int NINF = Integer.MIN_VALUE;

    static void dfs(int i, Stack <Integer> topo, boolean[] visited, ArrayList<ArrayList<Integer>> edges){
        visited[i] = true;
        for(int j = 0; j < edges.get(i).size(); j++){
            int x = edges.get(i).get(1);
            if(!visited[x])
                dfs(x, topo, visited, edges);
        }
        topo.push(i);
        return;
    }
    public static ArrayList<Integer> findMaxDistances(int n, int src, ArrayList<ArrayList<Integer>> edges) {

        for(ArrayList<Integer> x : edges){
            for(int y : x){
                System.out.print(y + " ");
            }System.out.println();
        }

        ArrayList <Integer> dist = new ArrayList<>();
        //topo sort through dfs
        Stack <Integer> topo = new Stack<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }

        dfs(src, topo, visited, edges);

        // ArrayList <Integer> dist = new ArrayList<>();
        for(int i = 0; i < n; i++)
            dist.add(NINF);
            adjList.get(e.src).add(Edge.of(e.src, e.dest, e.weight));
            adjList.get(e.dest).add(Edge.of(e.dest, e.src, e.weight));
            if(dist.get(top) != NINF){
                //if we can reach top
                for(int i = 0; i < edges.get(top).size(); i++){
                    int x = edges.get(top).get(1);
                    if(dist.get(x) < dist.get(top) + edges.get(top).get(2)){
                        dist.set(x, dist.get(top) + edges.get(top).get(2));
                    }
                }
            }

        return dist;
    }    
}
