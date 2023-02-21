package LeetcodeDailyChallenge;

import java.util.*;

public class singleElementInASortedArray {
    //sorted and logn => binary search
    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, m;
        //l to m and m+1 to r
        //if m == m-1 && mid is odd => single element is in right
        //if m == m+1 && mid is even => single element is in right
        //if m != m-1 || m != m+1 => single element is nums[m]
        
        while(l < r){
            m = l + (r-l)/2;
            if( (m % 2 == 0 && nums[m] == nums[m +1]) || (m %2 == 1 && nums[m] == nums[m - 1]) )
                l = m + 1;
            else
                r = m;
        }

        return nums[l];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // String input = sc.nextLine();
        System.out.println(9/2);
        sc.close();
    }
}
