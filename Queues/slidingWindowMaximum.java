package Queues;

import java.util.*;

public class slidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        //Deque is a doubly ll
        //brute force = O(n*k)

        //the index in deque is stored such that the elements corresponding to that index keep decreasing 

        //the first index will represent the max 
        //the last index will represent the min

        //for every i check if there is an index that doesnt fall in the k window and remove it from front 
        Deque <Integer> index = new ArrayDeque<>();
        int n = nums.length, in = 0;
        int[] ans = new int[n-k+1];

        for(int i = 0; i < n; i++){
            if(!index.isEmpty() && index.peek() == i-k){
                index.poll();
            }
            while(!index.isEmpty() && nums[i] > nums[index.peekLast()]){
                index.pollLast();
            }
            index.offer(i);
            if(i >= k-1){
                ans[in] = ans[index.peek()];
                in++;
            }
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
        System.out.println(maxSlidingWindow(arr, k));
        sc.close();
    }
}
