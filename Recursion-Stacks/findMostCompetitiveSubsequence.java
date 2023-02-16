import java.util.*;

public class findMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        //more competitive if the first differing number is less
        //increasing order
        int n = nums.length;
        int remove = n-k; // Number of elements that can be safely removed
        Stack<Integer> st = new Stack<>();
        st.push(nums[0]);

        for(int i = 1; i < n; i++){
            while(!st.isEmpty() && nums[i] < st.peek() && n - i + st.size() > k){
                st.pop();
            }
            if(st.size() < k)
                st.push(nums[i]);
        }
        nums = new int[k];

        for(int i = k-1; i >= 0; i--){
            nums[i] = st.pop();
        }

        return nums;
    }    
}
