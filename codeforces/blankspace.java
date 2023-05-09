package codeforces;

import java.util.*;

//longest consequtive 0s
class blankspace{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String check = "codeforces";
        while(t > 0){
            t--;
            int n = sc.nextInt();
            int local_max = 0, ans = 0;

            for(int i = 0; i < n; i++){
                int x = sc.nextInt();
                if(x == 0){
                    local_max++;
                    continue;
                }
                ans = Math.max(ans, local_max);
                local_max = 0;
            }
            ans = Math.max(ans, local_max);
            System.out.println(ans);
        }
    }
}