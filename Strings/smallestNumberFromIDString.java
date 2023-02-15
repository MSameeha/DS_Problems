import java.util.*;

public class smallestNumberFromIDString {
    public static String smallestNumber(String pattern) {
        StringBuilder ans = new StringBuilder(), stack = new StringBuilder();

        for(int i = 0; i <= pattern.length(); i++){
            stack.append((char)('1' + i));
            if(i == pattern.length() || pattern.charAt(i) == 'I'){
                ans.append(stack.reverse());
                stack = new StringBuilder();
            }
        }
        return ans.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(smallestNumber(input));
        sc.close();
    }
}
