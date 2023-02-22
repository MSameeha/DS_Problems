import java.util.*;

public class kthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        //take a max heap and store k element 
        //if k > 1 remove max element of heap => O(nlogk) TC and O(K){extra space}
        
        //use binary search and upper bound 
        //low = matrix[0][0] and high = matrix[n-1][m-1]
        //mid = low+high/2 {not the indices but the element itself}
        //if the number of elements less than mid < k -> low = mid+1
        //else high = mid

        //to count the number of elements less than k, take upperbound of k in each row

        int n = matrix.length, m = matrix[0].length;

        int low = matrix[0][0], high = matrix[n-1][m-1];

        while(low <= high){
            int mid = low + (high - low)/2;

            if(numberOfElements(matrix, k, mid)){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return high;
    }    
    private static boolean numberOfElements(int[][] matrix, int k, int mid){
        // int ans = 0, row = 0;

        // for(int i = 0; i < matrix.length; i++){
        //     for(int j = 0; j < matrix[0].length; j++){
        //         if(mid >= matrix[i][j]) row++;
        //         else break;
        //     }
        //     ans += row;
        //     row = 0;
        // }
        // return ans >= k;
        int cnt = 0, c = matrix[0].length - 1; // start with the rightmost column
        for (int r = 0; r < matrix.length; ++r) {
            while (c >= 0 && matrix[r][c] > mid) --c;  // decrease column until matrix[r][c] <= x
            cnt += (c + 1);
        }
        return cnt >= k;
    }
}
