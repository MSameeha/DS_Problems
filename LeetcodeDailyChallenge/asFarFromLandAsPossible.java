//Day - 10-02-2023
//BRUTE FORCE CODE

package LeetcodeDailyChallenge;

import java.util.*;

class Pair<L,R> {
    private L l;
    private R r;
    public Pair(L l, R r){
        this.l = l;
        this.r = r;
    }
    public L getL(){ return l; }
    public R getR(){ return r; }
    public void setL(L l){ this.l = l; }
    public void setR(R r){ this.r = r; }
}


public class asFarFromLandAsPossible {
    public static int maxDistance(int[][] grid) {
        //store all the land coordinates in a list
        //traverse every water and compute it's distance 
        
        List< Pair <Integer, Integer> > land = new ArrayList< Pair < Integer, Integer> >();

        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                //1 -> LAND
                if(grid[i][j] == 1){
                    Pair <Integer, Integer> p = new Pair(i, j);
                    // System.out.println("Land is at " + i + " " + j);
                    land.add(p);
                }
            }
        }

        int max_dist = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 0){
                    int dist = Integer.MAX_VALUE;
                    for(int k = 0; k < land.size(); k++){
                        int x = land.get(k).getL();
                        int y = land.get(k).getR();
                        dist = Math.min(dist, (Math.abs(x-i) + Math.abs(y-j)));
                    }
                    max_dist = Math.max(max_dist, dist);
                }
            }
        }
        if(max_dist == Integer.MAX_VALUE || max_dist == 0) max_dist = -1;
        return max_dist;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxDistance(mat));
        sc.close();
    }
}
