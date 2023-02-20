package HashMaps;

import java.util.*;

public class numbersSmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        //8 1 2 2 3
        //1 2 2 3 8
        int n = nums.length;
        int[] nums2 = new int[n];
        for(int i = 0; i < n; i++){
            nums2[i] = nums[i];
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> index = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(!index.containsKey(nums[i]))
                index.put(nums[i], i);
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = (index.get(nums2[i]));
        }

        return ans;
    }
}
