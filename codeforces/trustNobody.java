package codeforces;

import java.util.*;

public class trustNobody {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t > 0){
            t--;

            int n = sc.nextInt();
            int[] a = new int[n];

            for(int i = 0; i < n; i++){
                a[i] = sc.nextInt();
            }

            int liars = 0;
            int ans = -1;

            for(int i = 0; i < n; i++){
                liars = i;
                int lying = 0;
                for(int j = 0; j < n; j++){
                    if(liars < a[j]){
                        lying++;
                    }
                }
                if(lying == liars){
                    ans = liars;
                }
            }

            System.out.println(ans);
        }
    }
}
