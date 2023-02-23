package BinaryTrees;

import java.util.*;

public class sumOfDistancesInTree {
    static int[] res, count;
    static ArrayList<HashSet<Integer>> tree;
    public static int[] sumOfDistancesInTree(int N, int[][] edges) {
        tree = new ArrayList<HashSet<Integer>>();
        res = new int[N];
        count = new int[N];
        for (int i = 0; i < N ; ++i)
            tree.add(new HashSet<Integer>());
        for (int[] e : edges) {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        dfs(0, -1);
        for(int i = 0; i < N; i++){
            System.out.println(" For " + i + "  res[i] = " + res[i] + " count[i] = " + count[i]);
        }System.out.println("-----------------------------------------------------------------------");
        dfs2(0, -1);
        for(int i = 0; i < N; i++){
            System.out.println(" For " + i + "  res[i] = " + res[i] + " count[i] = " + count[i]);
        }
        return res;
    }

    public static void dfs(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            dfs(i, root);
            count[root] += count[i];
            res[root] += res[i] + count[i];
        }
        count[root]++;
    }


    public static void dfs2(int root, int pre) {
        for (int i : tree.get(root)) {
            if (i == pre) continue;
            res[i] = res[root] - count[i] + count.length - count[i];
            dfs2(i, root);
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