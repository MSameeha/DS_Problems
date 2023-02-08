import java.util.*;

public class medianOfTwoSortedArrays {
    
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ans = 0;
        int n = nums1.length, m = nums2.length;
        int size = n+m;
        int i = 0, n1 = 0, n2 = 0;
        int[] nums = new int[size];
        
        while(n1 < n && n2 < m){
            if(nums1[n1] <= nums2[n2]){
                nums[i] = nums1[n1++];
            }
            else{
                nums[i] = nums2[n2++];
            }
            i++;
        }
        while(n1 < n){
            nums[i++] = nums1[n1++];
        }
        while(n2 < m){
            nums[i++] = nums2[n2++];
        }

        size--;

        if(size % 2 != 0){
            //even 2 mean
            ans = (nums[size/2] + nums[(size/2)+1])/2.0;
        }else{
            ans = nums[size/2];
        }
        return ans;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] a1 = new int[n];
        int[] a2 = new int[n];
        for(int i = 0; i < n; i++){
            a1[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            a2[i] = sc.nextInt();
        }
        System.out.println(findMedianSortedArrays(a1, a2));
        sc.close();
    }
}
