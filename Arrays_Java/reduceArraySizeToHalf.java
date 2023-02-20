import java.util.*;

public class reduceArraySizeToHalf {
    public int minSetSize(int[] arr) {
        //sort the frequencies in decreasing order and sum of which two max frequencies >= n/2;
        HashMap<Integer, Integer> freq = new HashMap<>();


        for(int x: arr){
            freq.put(x, freq.getOrDefault(x, 0)+1);
        }

        int[] list = new int[freq.values().size()];
        int i = 0;

        for(int x: freq.values()){
            list[i++] = x;
        }

        Arrays.sort(list);
        int cnt = 0, sum = 0;

        for(i = list.length-1; i >= 0; i--){
            cnt++;
            sum += list[i];
            if(sum >= (arr.length/2)){
                return cnt;
            }
        }

        return -1;
    }
}
