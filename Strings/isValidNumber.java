import java.util.*;

public class isValidNumber {
    public static boolean isNumber(String s) {
        //. cannot come after a . or e/E

        //e can come only if a number has been seen and we didnt already see an e


        //we can only see +/- at the first position and after e

        boolean numberSeen = false, numberAfterE = false;
        boolean eSeen = false, dotSeen = false;
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '.'){
                if(dotSeen | eSeen){
                    return false;
                }
                dotSeen = true;
            }else if(s.charAt(i) == 'e' || s.charAt(i) == 'E'){
                if(eSeen | !numberSeen){
                    return false;
                }
                eSeen = true;
                numberAfterE = true;
            }else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                numberSeen = true;
                numberAfterE = true;
            }else if(s.charAt(i) == '+' || s.charAt(i) == '-'){
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }else{
                return false;
            }
        }
        return (numberSeen && numberAfterE);
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(isNumber(input));
        sc.close();
    }
}
