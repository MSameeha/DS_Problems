import java.util.*;

public class firstMissingPositive {
    public static void print(int[] nums){
        System.out.println("---------------");
        for(int x: nums){
            System.out.print(x + " ");
        }System.out.println("-----------------");
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            while(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1]!=nums[i]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
                print(nums);
            }
        }

        for(int i = 0; i < n; i++){
            if((i+1) != nums[i]){
                return i+1;
            }
        }

        return n+1;
    }

        // Input 1d int Array
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(firstMissingPositive(arr));
        sc.close();
    }
}
