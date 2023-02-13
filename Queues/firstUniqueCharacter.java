package Queues;

import java.util.*;

public class firstUniqueCharacter {
    // public static int firstUniqChar(String s) {
    //     HashMap <Character, Integer> freq = new HashMap<>();
    //     for(char ch : s.toCharArray()){
    //         freq.put(ch, freq.getOrDefault(ch, 0)+1);
    //     }
    //     int n = s.length();
    //     for(int i = 0; i < n; i++){
    //         if(freq.get(s.charAt(i)) == 1){
    //             return i;
    //         }
    //     }
    //     return -1;
    // }

    public static int firstUniqChar(String s) {
        
        int ans = s.length();
        for(char c = 'a'; c <= 'z'; c++){
            
            int index = s.indexOf(c);
            if(index != -1 && index == s.lastIndexOf(c)){
                ans = Math.min(ans, index);
            }
        }
        if(ans == s.length()) 
            return -1;
        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(firstUniqChar(input));
        sc.close();
    }
}
