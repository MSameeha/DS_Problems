package LeetcodeDailyChallenge;

import java.util.*;

public class spiralMatrix {

    static List<Integer> printSpiralMatrix(int[][] mat){
        List<Integer> res = new ArrayList<>();
        int n = mat.length, m = mat[0].length;
        int up = 0, left = 0, down = n-1, right = m-1;
        int dir = 0;

        while(up <= down && left <= right){
            
            for(int i = left; i <= right; i++)
                res.add(mat[up][i]);
            up++;

            for(int i = up; i <= down; i++)
                res.add(mat[i][right]);
            right--;

            if(up <= down){
                for(int i = right; i >= left; i--)
                    res.add(mat[down][i]);
            }
            down--;

            if(left <= right){
                for(int i = down; i >= up; i--)
                    res.add(mat[i][left]);
            }
            left++;
            
        }

        return res;
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
        
        List<Integer> ans = printSpiralMatrix(mat);
        
        for(int x : ans)
            System.out.print(x + " ");
        sc.close();
    }
}
