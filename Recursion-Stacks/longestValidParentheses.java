import java.util.*;

public class longestValidParentheses{

    public static int longestValidParentheses(String s) {
        if(s.length() == 0) return 0;
        Stack <Integer> index = new Stack<>();
        Stack <Character> brackets = new Stack<>();

        index.push(-1); // store index that can potentially create an invalid parentheses

        int ans = 0, n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '('){
                //push index and bracket
                index.push(i);
                brackets.push(s.charAt(i));
            }else if(s.charAt(i) == ')'){
                if(brackets.size() == 0){
                    //no opening bracket
                    index.push(i);
                    continue;
                }
                brackets.pop();
                index.pop();
                ans = Math.max(ans, i - index.peek());
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(longestValidParentheses(input));
        sc.close();
    }

}