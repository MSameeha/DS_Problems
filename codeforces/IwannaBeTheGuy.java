package codeforces;

import java.util.*;

public class IwannaBeTheGuy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        Set <Integer> s = new HashSet<>();

        for(int i = 0; i < p; i++){
            int x = sc.nextInt();
            s.add(x);
        }

        p = sc.nextInt();
        for(int i = 0; i < p; i++){
            int x = sc.nextInt();
            s.add(x);
        }

        if(s.size() == n) System.out.println("I become the guy.");
        else System.out.println("Oh, my keyboard!");
    }
}