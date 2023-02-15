package LeetcodeDailyChallenge;

import java.util.*;
import java.util.stream.Collectors;  

public class addToArrayForm{
    public static List<Integer> addToArrayForm(int[] num, int k) {
        LinkedList<Integer> ans = new LinkedList<>();
        int len = num.length-1;

        while(k != 0 || len >= 0){
            if(len >= 0){
                k += num[len];
            }
            ans.addFirst(k%10);
            len--;
            k = k/10;
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(addToArrayForm(arr, k));
        sc.close();
    }

}
