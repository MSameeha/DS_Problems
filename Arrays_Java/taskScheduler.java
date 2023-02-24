import java.util.*;

public class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char ch : tasks){
            freq[ch-'A']++;
        }

        Arrays.sort(freq);
        int max = freq[25];
        int idle_spaces = (max-1)*n;

        for(int i = 24; i >= 0; i--){
            idle_spaces -= Math.min(max-1, freq[i]);
        }
        return tasks.length + ((idle_spaces <  0)? 0 : idle_spaces);
    }
}
