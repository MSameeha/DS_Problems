package Graphs;

import java.util.*;

public class leastCostWithMEdges {

    static class Node {
        int vertex, depth, weight;
    
        Node(int v, int d, int w){
            vertex = v;
            depth = d;
            weight = w;
        }
    }
    
    static class Edge{
        int source, dest, weight;
        Edge(int src, int des, int w){
            this.source = src;
            this.dest = des;
            this.weight = w;
        }
    }
    
    static class Graph{
        List < List <Edge> > adjlist = null;
    
        Graph(List<Edge> edges, int N){
            adjlist = new ArrayList<>();
    
            for(int i = 0; i < N; i++){
                adjlist.add(i, new ArrayList<>());
            }
    
            for(Edge edge : edges){
                adjlist.get(edge.source).add(edge);
            }
        }
    }

    static int leastCostWithGivenEdges(int src, int dest, int m, Graph graph){

        Queue <Node> q = new LinkedList<>();
        q.add(new Node(src, 0, 0));

        int minCost = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Node node = q.poll();

            int vertex = node.vertex;
            int depth = node.depth;
            int cost = node.weight;

            if(vertex == dest && depth == m)
                minCost = Math.min(minCost, cost);

            if(depth > m)
                break; //next elements in queue will have depth >= current depth so no point visiting the next nodes
            
            for(Edge edge : graph.adjlist.get(vertex)){
                q.add(new Node(edge.dest, depth+1, cost + edge.weight));
            }
        }

        return minCost;
    }

    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
            new Edge(0, 6, -1), 
            new Edge(0, 1, 5), 
            new Edge(1, 6, 3),         
            new Edge(1, 5, 5), 
            new Edge(1, 2, 7), 
            new Edge(2, 3, 8),
            new Edge(3, 4, 10), 
            new Edge(5, 2, -1), 
            new Edge(5, 3, 9),
            new Edge(5, 4, 1), 
            new Edge(6, 5, 2), 
            new Edge(7, 6, 9),
            new Edge(7, 1, 6)
        );
        // Set number of vertices in the graph
        final int N = 8;

        // create a graph from given edges
        Graph graph = new Graph(edges, N);    
        System.out.println(leastCostWithGivenEdges(0, 3, 4, graph));
    }
}
