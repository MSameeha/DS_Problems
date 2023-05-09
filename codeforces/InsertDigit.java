package codeforces;

import java.util.*;
//1811 - A

public class InsertDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            int n = sc.nextInt();
            int digit = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder(s);

            if(digit == 0){
                sb.append(digit);
            }
            else{
                int i = 0;
                for(i = 0; i < n; i++){
                    int x = s.charAt(i) - 48;
                    if(x < digit){
                        System.out.println(s.charAt(i) + " " + x + " " + digit);
                        sb.insert(i, digit);
                        break;
                    } 
                }
                if(i == n)
                    sb.insert(n, digit);
            }

            System.out.println(sb);
        }
    }
}
