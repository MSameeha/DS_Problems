package Graphs;

import java.util.*;

//https://www.techiedelight.com/maximum-cost-path-graph-source-destination/
//title is wrong read description. One source to any destination cost > given_cost

public class maxCostGreaterThanCost {

    static class Node {
        int vertex, cost;
        Set <Integer> set;
    
        Node(int v, int c, Set<Integer> s){
            vertex = v;
            cost = c;
            set = s;
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
                adjlist.add(new ArrayList<>());
            }
    
            for(Edge edge : edges){
                System.out.println ( " GM: " + edge.source +  " " + edge.dest + " " + edge.weight);
                adjlist.get(edge.source).add(new Edge(edge.source, edge.dest, edge.weight));
                adjlist.get(edge.dest).add(new Edge(edge.dest, edge.source, edge.weight));
            }

            for(List <Edge> e : adjlist){
                for(Edge edge : e){
                    System.out.println(edge.source +  " " + edge.dest + " " + edge.weight);
                }
            }
        }
    }

    static int maxCostPath(int src, int cost, Graph graph){

        Queue<Node> q = new ArrayDeque<>();
        Set < Integer> vertices = new HashSet<>();
        vertices.add(src);
        q.add(new Node(src, 0, vertices)); //vertex cost set

        int maxCost = Integer.MIN_VALUE;

        while(!q.isEmpty()) {
            Node node = q.poll();
            System.out.println(node.vertex + " " + node.cost + " -> max " + maxCost);

            // vertices = node.

            if(node.cost > cost){
                maxCost = Math.max(maxCost, node.cost);
            }

            for(Edge edge: graph.adjlist.get(node.vertex)){
                if(!node.set.contains(edge.dest)){
                    System.out.println("src = " + node.vertex + " <-> " + edge.dest);
                    Set <Integer> s = new HashSet<>(node.set);
                    s.add(edge.dest);
                    q.add(new Node(edge.dest, node.cost + edge.weight, s));
                }
            }
        }

        return maxCost;
    }
    

    public static void main(String[] args) {
        // List of graph edges as per above diagram
        List<Edge> edges = Arrays.asList(
            new Edge(0, 6, 11), 
            new Edge(0, 1, 5),
            new Edge(1, 6, 3), 
            new Edge(1, 5, 5), 
            new Edge(1, 2, 7),
            new Edge(2, 3, -8), 
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
        Graph graph1 = new Graph(edges, N);    

        // List<Edge> edges1 = Arrays.asList(
        //     new Edge(0, 1, 2),
        //     new Edge(0, 3, 1),
        //     new Edge(1, 2, -1),
        //     new Edge(1, 3, -1),
        //     new Edge(3, 2, 1),
        //     new Edge(3, 4, 4),
        //     new Edge(1, 2, -1)
        // );        

        // Graph graph2 = new Graph(edges1, 5); 

        System.out.println(maxCostPath(0, 50, graph1));
    }
}
