package Graphs;

import java.util.*;

public class snakeAndLadder {
    static int minThrow(int N, int arr[]){
        HashMap <Integer, Integer> jumps = new HashMap<>(); //snake or ladder

        for(int i = 0; i < 2*N; i+=2){
            jumps.put(arr[i], arr[i+1]);
            // jumps.put(arr[i+1], arr[i]);
        }

        Queue <int[]> q = new LinkedList<>(); 
        //0 -> vertex 
        //1 -> distance 

        q.add(new int[] {1, 0});
        boolean[] visited = new boolean[37];
        for(int i = 0; i < 37; i++){
            visited[i] = false;
        }
        visited[1] = true;
        int v,d=0;
        
        while(!q.isEmpty()){
            int[] new_arr = new int[2];
            new_arr = q.poll();
            v = new_arr[0];
            d = new_arr[1];

            if(v == 30){
                return d;
            }

            for(int i = v + 1; i <= v+6; i++){
                if(!visited[i]){
                    visited[i] = true;
                    int nd = d+1, nv = i;

                    if(jumps.containsKey(i)){
                        //it cannot be reached by a snake or ladder 
                        nv = jumps.get(i);
                    }

                    q.add(new int[] {nv, nd});
                }
            }
        }
        return -1;
    } 
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[2*n];
        for(int i = 0; i < 2*n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minThrow(n, arr));
    }
}
