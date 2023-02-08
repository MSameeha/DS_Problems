import java.util.*;

public class template {
    public static void printStack(Stack<Integer> stack) {

        // Method 1:
        String values = Arrays.toString(stack.toArray());
        System.out.println(values);
    
        // // Method 2:
        // Object[] vals = stack.toArray();
        // for (Object obj : vals) {
        //     System.out.println(obj);
        // }
    }
    public static int lengthOfLongestSubstring(String s) {
        // HashMap <char, int> frequency = new HashMap <char, int>();
        int ans = 0;

        return ans;
    }
    // ---------------------------------------------------------------------------
    //INPUT ONE STRING
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
        sc.close();
    }
    // ---------------------------------------------------------------------------
    //INPUT TWO INTEGERS
    // public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // double x = sc.nextDouble();
        // int n = sc.nextInt();
        // System.out.println(myPow(x, n));
        // sc.close();
    // }
    // // ------------------------------------------------------------------------------
    // Input 2d integer matrix

    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     char[][] mat = new char[n][m];
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             mat[i][j] = sc.next().charAt(0);
    //         }
    //     }
    //     System.out.println(isValidSudoku(mat));
    //     sc.close();
    // }
    // -----------------------------------------------------------------------------------
    // Input 1d int Array
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     for(int i = 0; i < n; i++){
    //         arr[i] = sc.nextInt();
    //     }
    //     System.out.println(maximumSum(arr));
    //     sc.close();
    // }
    // --------------------------------------------------------------------------------------
}
