package LeetcodeDailyChallenge;

import java.util.ArrayDeque;
import java.util.Deque;

public class searchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        
        int r = nums.length - 1;
        int l = 0;
        
        while(l < r){
            int mid = l + (r-l)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] < target){
                l = mid+1;
            }else{
                r = mid;
            }
        }

        return nums[l] < target? l+1 : l;
    }    
}
