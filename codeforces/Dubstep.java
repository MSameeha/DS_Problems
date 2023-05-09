package codeforces;

import java.util.*;

public class Dubstep {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int n = s.length();

        String temp = new String();
        StringBuilder sb = new StringBuilder();
        temp = "";

        for(int i = 0; i < n; i++){
            if(i+2 < n && s.charAt(i) == 'W' && s.charAt(i+1) == 'U' && s.charAt(i+2) == 'B'){
                if(temp.length() != 0){
                    sb.append(temp);
                    sb.append(" ");
                }
                temp = "";
                i+=2;
            }else{
                temp += s.charAt(i);
            }
        }
        sb.append(temp);
        System.out.println(sb);
    }
}
