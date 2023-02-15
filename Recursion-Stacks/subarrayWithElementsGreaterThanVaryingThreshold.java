import java.util.*;

public class subarrayWithElementsGreaterThanVaryingThreshold {
    public static int validSubarraySize(int[] nums, int threshold) {
        int n = nums.length;

        int[] next_smaller = new int[n];
        int[] prev_smaller = new int[n];
        Stack<Integer> index = new Stack<>();

        Arrays.fill(next_smaller, n);
        Arrays.fill(prev_smaller, -1);

        for(int i = 0; i < n; i++){
            while(!index.isEmpty() && nums[index.peek()] >= nums[i]){
                index.pop();
            }
            if(!index.isEmpty()){
                prev_smaller[i] = index.peek();
            }
            index.push(i);
        }

        index = new Stack<>();
        for(int i = n-1; i >= 0; i--){
            while(!index.isEmpty() && nums[index.peek()] >= nums[i]){
                index.pop();
            }
            if(!index.isEmpty()){
                next_smaller[i] = index.peek();
            }
            index.push(i);
        }

        for(int i = 0; i < n; i++){
            int max_len = next_smaller[i] - prev_smaller[i] - 1;

            if(threshold/ max_len < nums[i]){
                return max_len;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(validSubarraySize(arr, k));
        sc.close();
    }

}
