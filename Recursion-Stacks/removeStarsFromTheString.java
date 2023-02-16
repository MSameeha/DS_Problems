import java.util.*;

public class removeStarsFromTheString {
    public static String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for(int i = 0; i < n; i++){
            if(s.charAt(i) != '*'){
                sb.append(s.charAt(i));
            }else{
                sb.deleteCharAt(sb.length()-1);
            }
        }

        return sb.reverse().toString();
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(removeStars(input));
        sc.close();
    }
}
