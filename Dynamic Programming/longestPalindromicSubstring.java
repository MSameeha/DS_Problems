import java.util.*;

public class longestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp_matrix = new int[n][n];
        // String ans = String.valueOf(s.charAt(0));
        int ans_i = 0, ans_j = 0;
        for(int len = 0; len < n; len++){
            for(int i = 0; i+len < n; i++){
        //         // dp_matrix[i][i+len] = 1;
                if(len == 0 || (s.charAt(i) == s.charAt(i+len) && (dp_matrix[i+1][i+len-1] == 1 || len == 1))){
                    dp_matrix[i][i+len] = 1;
                }else{
                    dp_matrix[i][i+len] = 0;
                }
                if(dp_matrix[i][i+len] == 1 && len > ans_j - ans_i){
                    ans_i = i;
                    ans_j = i+len;
                }
            }
        }
        // for(int i = 0; i < n; i++){
        //     int j = n-1;
        //     for(j = n-1; j > i; j--){
        //         if(dp_matrix[i][j] == 1 && max < j-i+1){
        //             max = j-i+1;
        //             ans_i = i;
        //             ans_j = j;
        //         }
        //     }
        // }
        // for(int i = ans_i; i <= ans_j; i++){
        //     if(ans_i == i){
        //         ans = "";
        //     }
        //     ans += s.charAt(i);
        // }

        return s.substring(ans_i, ans_j+1);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(longestPalindrome(input));
        sc.close();
    }
    
}
