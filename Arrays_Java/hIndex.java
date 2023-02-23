import java.util.*;

public class hIndex {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] freq = new int[n+1];

        for(int x: citations){
            freq[Math.min(x, n)]++;
        }
        int sum = 0;
        for(int i = n; i >= 0; i--){
            sum += freq[i];

            if(sum >= i){
                return i;
            }
        }
        return -1;
    } 
}
