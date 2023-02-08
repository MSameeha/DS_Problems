import java.util.*;

public class regularExpressionMatching {

    //Have a DP 
    
    public static boolean isMatch(String s, String p) {
        int input_length = s.length(), pattern_length = p.length();
        boolean[][] dp_matrix = new boolean[input_length+1][pattern_length+1];

        // if(s == null || p == null) return false;
        //populate dp_matrix[0][j] && dp_matrix[i][0]

        //empty string
        dp_matrix[0][0] = true;

        for(int i = 0; i < input_length; i++){
            //no string can match an empty string except for when it, itself is empty
            dp_matrix[i+1][0] =  false;
        }

        for(int j = 1; j <= pattern_length; j++){
            if(p.charAt(j-1) == '*'){
                dp_matrix[0][j] = dp_matrix[0][j-2];
            }
        }
        // for(int i = 0; i <= input_length; i++){
        //     for(int j = 0; j <= pattern_length; j++){
        //         System.out.print(dp_matrix[i][j] + " ");
        //     }System.out.println();
        // }
        //fill matrix
        for(int i = 0; i < input_length; i++){
            for(int j = 0; j < pattern_length; j++){
                //If the string and character match or pattern accepts any character
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'){
                    dp_matrix[i+1][j+1] = dp_matrix[i][j];
                }else if(p.charAt(j) == '*'){
                    //The p[j-1] can have zero occurences or more

                    //Zero occurences of p[j-1]
                    dp_matrix[i+1][j+1] = dp_matrix[i+1][j-1];

                    //one occurence 
                    boolean occurences = false;
                    if(s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                        occurences = dp_matrix[i][j+1];
                    }

                    dp_matrix[i+1][j+1] = (occurences | dp_matrix[i+1][j+1]);

                }else{
                    dp_matrix[i+1][j+1] = false;
                }
            }
        }
        for(int i = 0; i <= input_length; i++){
            for(int j = 0; j <= pattern_length; j++){
                System.out.print(dp_matrix[i][j] + " ");
            }System.out.println();
        }
        return (dp_matrix[input_length][pattern_length]);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String pattern = sc.nextLine();
        System.out.println(isMatch(input, pattern));
        sc.close();
    }  
}
