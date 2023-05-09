package codeforces;

import java.util.*;

// https://codeforces.com/contest/514/problem/A

public class ChewbaccaAndNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < n; i++){
            if(s.charAt(i) > '4'){
                if(s.charAt(i) == '9' && i == 0){
                    continue;
                }
                int x = 9 - ((int)s.charAt(i))+48;
                char ch = Character.forDigit(x, 10);
                // System.out.println(ch + " num " + x);
                sb.setCharAt(i, ch);
            }
        }
        System.out.println(sb);
    }
}
