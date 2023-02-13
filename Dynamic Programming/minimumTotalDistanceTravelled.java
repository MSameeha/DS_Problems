import java.util.*;

public class minimumTotalDistanceTravelled {
    public static long rec(List<Integer> robot, int[][] factory, long[][] dp_matrix, int r_ind, int f_ind){
        int r = robot.size();
        int f = factory.length;

        if(r_ind >= r) return 0L;
        if(f_ind >= f) return Long.MAX_VALUE;

        long ans = dp_matrix[r_ind][f_ind];
        if(ans != -1) return ans;

        ans = rec(robot, factory, dp_matrix, f_ind+1, r_ind);

        long x = 0;

        for(int k = r_ind; k < robot.size() && k-r_ind+1 <= factory[f_ind][1]; k++){
            x += Math.abs(robot.get(k) - factory[f_ind][0]);

            long p = rec(robot, factory, dp_matrix, f_ind+1, k+1);

            if(p != Long.MAX_VALUE){
                ans = Math.min(ans, x+p);
            }
        }

        return dp_matrix[r_ind][f_ind] = ans;
    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, (a,b) -> (a[0]-b[0]));

        Collections.sort(robot);

        long[][] dp = new long[robot.size()+1][factory.length+1];

        for(int i = 0; i <= robot.size(); i++){
            for(int j = 0; j <= factory.length; j++){
                dp[i][j] = -1;
            }
        }

        return rec(robot, factory, dp, 0, 0);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int robot_size = sc.nextInt();
        List<Integer> robot = new ArrayList<>();
        for(int i = 0; i < robot_size; i++){
            robot.add(sc.nextInt());
        }
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(minimumTotalDistance(robot, mat));
        sc.close();
    }
}
