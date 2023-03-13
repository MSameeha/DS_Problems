import java.util.*;

public class threePartitionEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = Arrays.stream(A).sum(), part = 0, average = sum / 3, cnt = 0;
        for (int a : A) {
            part += a;
            if (part == average) { // find the average: sum / 3
                ++cnt; // find an average, increase the counter.
                part = 0; // reset part.
            }
        }
        return cnt >= 3 && sum % 3 == 0;
//     } 
//     public boolean canThreePartsEqualSum(int[] arr) {
//         int n = arr.length;
//         int[] prefix_sum = new int[n];
//         int[] suffix_sum = new int[n];
        
//         int sum = 0, i = 0;
//         for(int x: arr){
//             sum += x;
//             prefix_sum[i] = sum;
//             i++;
//         }
        
//         sum = 0;
//         for(i = n-1; i >= 0; i--){
//             sum += arr[i];
//             suffix_sum[i] = sum;
//         }

//         if(sum % 3 != 0) return false;

//         int pos1 = -1, pos2 = -1, j = n-1;
//         i = 0;
//         while(i < j-1){
//             if(prefix_sum[i] == sum/3){
//                 pos1 = i;
//             }
//             if(suffix_sum[j] == sum/3){
//                 pos2 = j;
//             }

//             if(pos1 != -1 && pos2 != -1){
//                 if(suffix_sum[pos1+1] - suffix_sum[pos2] == sum/3){
//                     return true;
//                 }return false;
//             }

//             if(prefix_sum[i] < suffix_sum[j]){
//                 i++;
//             }else{
//                 j--;
//             }
//         }
//         return false;

    }
}
