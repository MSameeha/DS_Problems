package codeforces;

import java.util.*;

class lovestory{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String check = "codeforces";
        while(t > 0){
            t--;
            sc.nextLine();
            String s = sc.nextLine();
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                if(s.charAt(i) != check.charAt(i)){
                    cnt++;
                }
            }

            System.out.println(cnt);
        }
    }
}