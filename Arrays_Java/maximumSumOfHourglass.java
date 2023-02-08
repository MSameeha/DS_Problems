import java.util.*;

public class maximumSumOfHourglass {
    public static int maxSum(int[][] grid) {
        long ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        int sum = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i-1 >= 0 && j-1 >= 0 && j+1 < m && i+1 < n && j+1 < m){
                    sum = grid[i-1][j-1] + grid[i-1][j] + grid[i-1][j+1] + grid[i+1][j-1] + grid[i+1][j] + grid[i+1][j+1] + grid[i][j];
                    // System.out.println(grid[i-1][j-1] + " " + grid[i-1][j+1] + " " + grid[i+1][j-1] + " " + grid[i+1][j+1] + " " + grid[i][j]);
                } 
                ans = Math.max(ans, sum);
            }
        }

        return (int)ans;
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
        System.out.println(maxSum(mat));
        sc.close();
    }
}
