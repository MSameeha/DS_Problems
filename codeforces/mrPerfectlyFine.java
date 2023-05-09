package codeforces;

import java.util.*;

public class mrPerfectlyFine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String check = "codeforces";
        while(t > 0){
            t--;
            int n = sc.nextInt();
            int minA = Integer.MAX_VALUE, minB = Integer.MAX_VALUE, minBoth = Integer.MAX_VALUE;
            int ans = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                int x = sc.nextInt();

                String s = sc.nextLine();

                if(s.charAt(1) == '1' && s.charAt(2) == '1'){
                    minBoth = Math.min(minBoth, x);
                }else if(s.charAt(1) == '1'){
                    minA = Math.min(minA, x);
                }else if(s.charAt(2) == '1'){
                    minB = Math.min(minB, x);
                }
                if(minA != Integer.MAX_VALUE && minB != Integer.MAX_VALUE)
                    ans = Math.min(ans, Math.min(minA + minB, minBoth));
                if(minBoth != Integer.MAX_VALUE){
                    ans = Math.min(ans, minBoth);
                }
            }
            if(ans == Integer.MAX_VALUE){
                System.out.println("-1");
            }else{
                System.out.println(ans);
            }

            // System.out.println(ans);
        }
    }
}
