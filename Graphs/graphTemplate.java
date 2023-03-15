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
        adjlist = new ArrayList<>();

        for(int i = 0; i < N; i++){
            adjlist.add(i, new ArrayList<>());
        }

        for(Edge edge : edges){
            adjlist.get(edge.source).add(edge);
        }
    }
}

public class graphTemplate {
    
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

        // create a graph from given edges
        Graph graph = new Graph(edges, N);    
    }
}
