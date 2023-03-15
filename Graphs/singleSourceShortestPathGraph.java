package Graphs;

import java.util.*;

class Edge{
    int source, dest, weight;
    Edge(int src, int des, int w){
        this.source = src;
        this.dest = des;
        this.weight = w;
    }
}

class Graph{
    List < List <Edge> > adjlist = null;

    Graph(List<Edge> edges, int N){
        adjlist = new ArrayList<>(N);

        for(int i = 0; i < N; i++){
            adjlist.add(i, new ArrayList<>());
        }

        for(Edge edge : edges){
            adjlist.get(edge.source).add(edge);
        }
    }
}

public class singleSourceShortestPathGraph {

    static int NINF = Integer.MIN_VALUE;

    static void dfs(int i, Stack <Integer> topo, boolean[] visited, Graph graph){
        visited[i] = true;
        for(int j = 0; j < graph.adjlist.get(i).size(); j++){
            int x = graph.adjlist.get(i).get(j).dest;
            if(!visited[x])
                dfs(x, topo, visited, graph);
        }
        topo.push(i);
        return;
    }
    public static ArrayList<Integer> findMaxDistances(int n, int src, Graph graph) {
        //topo sort through dfs
        Stack <Integer> topo = new Stack<>();
        boolean[] visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            visited[i] = false;
        }

        for(int i = 0; i < n; i++)
            if(!visited[i])
                dfs(src, topo, visited, graph);

        ArrayList <Integer> dist = new ArrayList<>();
        for(int i = 0; i < n; i++)
            dist.add(NINF);
        
        dist.add(src, 0);

        while(!topo.isEmpty()){
            int x = topo.pop();

            if(dist.get(x) != NINF){
                for(int j = 0; j < graph.adjlist.get(x).size(); j++){
                    int neighbor = graph.adjlist.get(x).get(j).dest;
                    if(dist.get(neighbor) < dist.get(x) + graph.adjlist.get(x).get(j).weight){
                        dist.set(neighbor, dist.get(x) + graph.adjlist.get(x).get(j).weight);
                    }
                }
            }
        }

        return dist;
    }  

    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
            new Edge(0, 1, 5),
            new Edge(2, 3, 7),
            new Edge(0, 2, 3),
            new Edge(3, 5, 1),
            new Edge(1, 3, 6),
            new Edge(3, 4, -1),
            new Edge(1, 2, 2),
            new Edge(4, 5, -2),
            new Edge(2, 4, 4),
            new Edge(2, 5, 2)
        );

        // Set number of vertices in the graph
        final int N = 6;
        int src = 1;
        Graph graph = new Graph(edges, N);    

        ArrayList<Integer> dist = findMaxDistances(N, src, graph);
        for(int x: dist){
            System.out.print(x + " ");
        }System.out.println();
    }
}
