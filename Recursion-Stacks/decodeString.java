import java.util.*;

public class decodeString {
    public static String decodeString(String s) {
        Stack<String> cha = new  Stack<>();
        Stack<Integer> nums = new Stack<>();
        String ans = "";

        //2[pj3[cj]]
        int i = 0; 
        while(i < s.length()){
            if(Character.isDigit(s.charAt(i))){
                int num = 0;
                while(Character.isDigit(s.charAt(i))){
                    num = (10*num) + s.charAt(i) - '0';
                    i++;
                }
                nums.push(num);
            }
            else if(s.charAt(i) == '['){
                cha.push(ans);
                ans = "";
                i++;
            }
            else if(s.charAt(i) == ']'){
                StringBuilder sb = new StringBuilder();
                sb.append(cha.pop());
                int times = nums.pop();

                for(int j = 0; j < times; j++){
                    sb.append(ans);
                }
                ans = sb.toString();
                i++;

            }else{
                ans += s.charAt(i);
                i++;
            }
        }
        
        return ans;
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(decodeString(input));
        sc.close();
    }
}
