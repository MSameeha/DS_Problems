package BinaryTrees;

import java.util.*;

public class sumOfDistancesInTree {
    static List < HashSet < Integer> > tree;
    static int[] subtree;
    static int[] distance;
    public static int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree = new ArrayList<>();
        for (int i = 0; i < n ; ++i)
            tree.add(new HashSet<Integer>());

        for(int[] e : edges){
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }

        subtree = new int[n];
        distance = new int[n];
        dfs_post(0, -1);
        dfs_pre(0, -1);

        return distance;
    }

    static void dfs_post(int root, int parent){
        for(int i : tree.get(root)){
            if(i == parent) continue;
            dfs_post(i, root);
            subtree[root] += subtree[i];
            distance[root] += distance[i] + subtree[i];
        }
        subtree[root]++;
    }

    static void dfs_pre(int root, int parent){
        for(int i : tree.get(root)){
            if(i == parent) continue;
            distance[i] = distance[root] - subtree[i] + subtree.length - subtree[i];
            dfs_pre(i, root);
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] edges = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < 2; j++){
                edges[i][j] = sc.nextInt();
            }
        }

        int[] arr = (sumOfDistancesInTree(n+1, edges));
        for(int x: arr){
            System.out.print(x + " ");
        }System.out.println();
        sc.close();
    }
}