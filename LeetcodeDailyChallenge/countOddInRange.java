package LeetcodeDailyChallenge;

import java.util.*;

//BEATS 100 IN TIME AND 18 IN MEMORY

public class countOddInRange {
    public static int countOdds(int low, int high) {
        //low and high are even 1
        //low and high are odd 2
        //low is even high is odd 3
        //low is odd high is even 4
        //high-low is odd 5
        //high-low is even 6
        if(low == high && low%2 == 0) return 0;
        if(low == high && low%2 == 1) return 1;
        int diff = high - low, ans = 0;
        if(diff % 2 == 0){
            //diff is even so floor or ceil tbd
            ans += (diff-1)/2;
            if(low % 2 == 0 && high % 2 == 0){
                //low and high are even
                ans += ((diff-1)%2);
            }else{
                ans += 2;
            }
        }else{
            ans = 1;
            ans += (diff-1)/2;
        }
        return ans;
    }
    
    //INPUT TWO INTEGERS
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(countOdds(x, n));
        sc.close();
    }
}
