import java.util.*;

public class longestSubstringWithoutRepeatingCharacters{
    public static int lengthOfLongestSubstring(String s) {
        HashMap <Character, Integer> frequency = new HashMap <Character, Integer>();
        int ans = 0;
        for(int i = 0, j = 0; j < s.length(); j++){
            //j is right pointer
            //i is left pointer
            if(frequency.containsKey(s.charAt(j))){
                i = Math.max(i, frequency.get(s.charAt(j)));
            }
            ans = Math.max(ans, j-i+1);
            frequency.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
        sc.close();
    }
}