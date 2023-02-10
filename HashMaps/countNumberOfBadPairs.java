package HashMaps;

import java.util.*;

public class countNumberOfBadPairs {
    public static long countBadPairs(int[] nums) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        long count = 0;
        for(int i = 0; i < nums.length; i++){
            int diff = i - nums[i];
            if(seen.containsKey(diff)){
                count += (i - seen.get(diff));
            }else{
                count += i;
            }
            seen.put(diff, seen.getOrDefault(diff, 0) + 1);
        }
        return count;
    }

       public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(countBadPairs(arr));
        sc.close();
    } 
}
