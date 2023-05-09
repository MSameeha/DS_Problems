package codeforces;

import java.util.*;

// https://codeforces.com/problemset/problem/443/A

public class antonAndLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();

        HashSet<Character> set = new HashSet<>();

        for(int i = 1; i < n; i++){
            if(s.charAt(i) == '}' || s.charAt(i) == ',' ||  s.charAt(i) == ' ')
                continue;
            set.add(s.charAt(i));
        }

        System.out.println(set.size());
    }
}
