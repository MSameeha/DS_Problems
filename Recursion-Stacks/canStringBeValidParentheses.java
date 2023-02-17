import java.util.*;

public class canStringBeValidParentheses {
    public boolean canBeValid(String s, String locked) {
        int balance = 0, n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '(' || locked.charAt(i) == '0') balance++;
            else balance --;
            if(balance < 0) return false;
        }
        balance = 0;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == ')' || locked.charAt(i) == '0') balance++;
            else balance--;
            if(balance < 0) return false;
        }
        return true;
    }
}
