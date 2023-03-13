import java.util.*;

public class wordProblem {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] substr = new boolean[s.length()+1];
        substr[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                if(substr[j] && wordDict.contains(s.substring(j, i))){
                    substr[i] = true;
                    break;
                }
            }
        }

        return substr[s.length()];
    }    
}

