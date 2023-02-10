package HashMaps;

import java.util.*;

public class optimalPartitionsOfAString {
    public static int partitionString(String s) {
        int ans = 0, n = s.length();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < n; i++){
            if(!set.add(s.charAt(i))){
                //already exists
                set.clear();
                set.add(s.charAt(i));
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(partitionString(input));
        sc.close();
    }
}
