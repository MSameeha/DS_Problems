package Math;

import java.util.*;

public class permutationSequence{

    public static String getPermutation(int n, int k) {
        //n = 4, k = 17
        List<Integer> nums = new ArrayList<>();
        int fact = 1;
        for(int i = 1; i < n; i++){
            fact = fact * i;
            nums.add(i);
        }
        nums.add(n);
        k = k-1;
        String ans = "";
        while(true){
            ans = ans + (nums.get(k/fact));
            nums.remove(k/fact);

            if(nums.size() == 0){
                break;
            }

            k = k % fact;
            fact = fact / nums.size();
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(getPermutation(x, n));
        sc.close();
    }

}