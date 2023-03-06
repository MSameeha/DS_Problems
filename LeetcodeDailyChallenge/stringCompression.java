package LeetcodeDailyChallenge;

import java.util.*;

public class stringCompression {
    public int compress(char[] chars) {
        int i = 0, j = 0;
        
        for(; j < chars.length && i < chars.length; ){
            char ch = chars[j];
            int cnt = 1;
            chars[i] = chars[j];
            while(j < chars.length && ch == chars[j]){
                j++;
                cnt++;
            }
            if(cnt == 1){
                i = i+1;
                continue;
            }
            if(i+1 < chars.length)
                chars[i+1] = (char)cnt;
            for(char c: chars){
                System.out.print(c + " ");
            }System.out.println();
            i+=2;
        } 
        return i;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        
        System.out.println(lengthOfLongestSubstring(input));
        sc.close();
    }
}
