import java.util.*;

public class removeDuplicates {
    public static int removeDuplicate(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return 1;
        }
        HashMap <Integer, Integer> freq = new HashMap<>();
        int unique = -1;
        for(int i = 0; i < n;){
            if(freq.containsKey(nums[i])){
                System.out.println(nums[i] + " " + i + " has");
                i++;
            }else{
                freq.put(nums[i], i);
                System.out.println(nums[i] + " " + i + " no has");
                unique++;
                nums[unique] = nums[i];
            }
        }
        return unique+1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a1 = new int[n];
        for(int i = 0; i < n; i++){
            a1[i] = sc.nextInt();
        }
        System.out.println(removeDuplicate(a1));
        for(int i = 0; i < n ; i++){
            System.out.print(a1[i] + " ");
        }
        sc.close();
    } 
}
