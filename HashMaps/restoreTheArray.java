package HashMaps;

import java.util.*;

public class restoreTheArray {

    public static int[] restoreArray(int[][] adjacentPairs) {
        HashMap<Integer, Integer> map = new HashMap<>(); // unique element and index
        int n = adjacentPairs.length, m = adjacentPairs[0].length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                
            }
        }
        return ans;
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
        System.out.println(restoreArray(mat));
        sc.close();
    }  
}
