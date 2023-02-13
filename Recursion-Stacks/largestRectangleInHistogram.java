import java.util.*;

public class largestRectangleInHistogram {

    public static int largestRectangleArea(int[] heights) {
        //Brute force - for each element we move forward and find right smallest and move back and find left smallest index
        //the area of histogram with height = a[i] => (rightSmallest - leftSmallest + 1)*a[i]

        //optimize the part where we calculate the next smallest element on either side by using stacks

        Stack<Integer> st =  new Stack<>();
        int n = heights.length;
        int[] leftSmallest = new int[n];
        int[] rightSmallest = new int[n];

        for(int i = 0; i < n; i++){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.empty()){
                st.push(i);
                leftSmallest[i] = 0;
            }else{
                leftSmallest[i] = st.peek()+1;
                st.push(i);
            }
        }
        // System.out.println("Left smallest -");
        // for(int x: leftSmallest){
        //     System.out.print(x + " ");
        // }System.out.println();

        st.clear();
        for(int i = n-1; i >= 0; i--){
            while(!st.empty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.empty()){
                st.push(i);
                rightSmallest[i] = n-1;
            }else{
                rightSmallest[i] = st.peek()-1;
                st.push(i);
            }            
        }
        // System.out.println("Right smallest -");
        // for(int x: rightSmallest){
        //     System.out.print(x + " ");
        // }System.out.println();
        int ans = 0;
        for(int i = 0; i < n; i++){
            int local = (rightSmallest[i] - leftSmallest[i] + 1) * heights[i];
            ans = Math.max(ans, local);
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
        System.out.println(largestRectangleArea(arr));
        sc.close();
    }

}
