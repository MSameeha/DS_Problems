import java.util.*;

public class minimumNumberOfSwapsToBalanceString {

    public int minSwaps(String s) {
        
        //we have a variable extra closing brackets
        //ecb-- if opening bracket
        //ecb++ if closing bracket

        //]]] -> 3 extra closing bracket
        //After a swap
        //[]] -> 1 extra closing bracket

        int n = s.length(), ecb = 0, ans = 0;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '['){
                ecb--;
            }else{
                ecb++;
            }
            ans = Math.max(ans, ecb);
        }
        return ans+1/2;
    }
}
