package Graphs;

import java.util.*;

class Node implements Comparator<Node>{
    private int v;
    private int weight;

    Node(){}

    Node(int v, int w){
        this.v = v;
        weight = w;
    }

    int getV(){
        return v;
    }

    int getWeight(){
        return weight;
    }

    @Override
    public int compare(Node node1, Node node2){
        if(node1.weight < node2.weight) return -1;
        if(node1.weight > node2.weight) return 1;
        return 0;
    }
}

public class dijkstra {

    void shortestPath(ArrayList<ArrayList<Node>> adj, int source, int number_of_nodes){
        int dist[] = new int[number_of_nodes];

        for(int i = 0; i < number_of_nodes; i++){
            dist[i] = Integer.MAX_VALUE;
        }
        dist[source] = 0;

        PriorityQueue < Node > pq = new PriorityQueue<>(number_of_nodes, new Node());

        pq.add(new Node(source, 0));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            for(Node it: adj.get(node.getV())){
                if(dist[node.getV()] + it.getWeight() < dist[it.getV()]){
                    dist[it.getV()] = dist[node.getV()] + it.getWeight();
                    pq.add(new Node(it.getV(), dist[it.getV()]));
                }
            }
        }

        System.out.println("The distances from source "+source+" are : ");
        for (int i = 0; i < number_of_nodes; i++)
        {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number_of_nodes, number_of_edges;

        // System.out.println("Enter no of nodes and no of edges");
        number_of_nodes = sc.nextInt();
        number_of_edges = sc.nextInt();

        ArrayList< ArrayList < Node> > adjacency_list = new ArrayList< ArrayList< Node > >();

        for(int i = 0; i < number_of_nodes; i++){
            adjacency_list.add(new ArrayList<>());
        }

        // System.out.println("Enter edges");
        for(int i = 0; i < number_of_edges; i++){
            int x = sc.nextInt(), y = sc.nextInt(), weight = sc.nextInt();
            // System.out.println(x + " " + y + " " + weight);
            adjacency_list.get(x).add(new Node(y, weight));
            adjacency_list.get(y).add(new Node(x, weight));
        }
		// adjacency_list.get(0).add(new Node(1, 2));
		// adjacency_list.get(1).add(new Node(0, 2));
		
		// adjacency_list.get(1).add(new Node(2, 4));
		// adjacency_list.get(2).add(new Node(1, 4));
		
		// adjacency_list.get(0).add(new Node(3, 1));
		// adjacency_list.get(3).add(new Node(0, 1));
		
		// adjacency_list.get(3).add(new Node(2, 3));
		// adjacency_list.get(2).add(new Node(3, 3));
		
		// adjacency_list.get(1).add(new Node(4, 5));
		// adjacency_list.get(4).add(new Node(1, 5));
		
		// adjacency_list.get(2).add(new Node(4, 1));
		// adjacency_list.get(4).add(new Node(2, 1));

        // System.out.println("Enter source node");
        int source = sc.nextInt();

        for(int i = 0; i < number_of_edges; i++){
            System.out.print(i + " -> ");
            for(Node node: adjacency_list.get(i)){
                System.out.print("( " + node.getV() + " , " + node.getWeight() + " ), ");
            }System.out.println();
        }

        dijkstra object = new dijkstra();
        object.shortestPath(adjacency_list, source, number_of_nodes);
        sc.close();
    }
}
