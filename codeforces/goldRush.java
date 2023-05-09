package codeforces;

import java.util.*;

public class goldRush {

    static String solve(int n, int m){
        if(n == m){
            return "YES";
        }

        if(n % 3 == 0){
            solve(n/3, m);
            solve(n - n/3, m);
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t > 0){
            t--;
            int n = sc.nextInt();
            int m = sc.nextInt();

            //max number of times the operation can be performed = log n base 3
            //log 10^7 base 3 = 14.something
            //perform operations
            
            System.out.println(solve(n, m));
        }
    }
}
