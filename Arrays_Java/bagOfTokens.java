import java.util.*;

public class bagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1, score = 0, maxScore = 0;

        while(left <= right){
            if(power >= tokens[left]){
                power = power - tokens[left];
                left++;
                score++;
                maxScore = Math.max(score, maxScore);
            }else{
                power += tokens[right];
                right--;
                score--;
            }
        }

        return maxScore;
    }
}
