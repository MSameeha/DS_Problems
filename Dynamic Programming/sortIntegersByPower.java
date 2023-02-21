import java.util.*;

public class sortIntegersByPower {
    static HashMap<Integer, Integer> dp;
    public static int getKth(int lo, int hi, int k) {
        dp = new HashMap<>();
        dp.put(1, 0);
        int[][] ans = new int[hi-lo+1][];
        int index = 0;

        for(int i = lo; i <= hi; i++){
            ans[index++] = new int[] {i, util(i)};
        }

        Arrays.sort(ans, (row1, row2) -> row1[1]-row2[1]);
        return ans[k-1][0];
    } 

    static int util(int val){
        if(dp.containsKey(val)){
            return dp.get(val);
        }
        int i = val, cnt = 0;
        while(val > 1){
            val = (val % 2 == 0)? val/2 : 3*val+1;
            cnt++;
        }
        dp.put(i, cnt);
        return dp.get(i);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        System.out.println(getKth(x, n, k));
        sc.close();
    }

}
