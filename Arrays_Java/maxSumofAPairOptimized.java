
import java.util.*;
//Beats 56 in time and 61 FROM 7 and 29
public class maxSumofAPairOptimized{

    static int findDigitSum(int n)
    {
        int sum;
 
        for (sum = 0; n > 0; sum += n % 10, n /= 10) ;
 
        return sum;
    }


    public static int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            int digitSum = findDigitSum(nums[i]);

            if(map.containsKey(digitSum)){
                sum = Math.max(sum, (map.get(digitSum) + nums[i]));
                map.put(digitSum, Math.max(map.get(digitSum), nums[i]));
            }else{
                map.put(digitSum, nums[i]);
            }
        }
        
        if(sum == 0) return -1;
        return sum;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maximumSum(arr));
        sc.close();
    }
}
