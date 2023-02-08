import java.util.*;

public class basicCalculator {
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
    // public static int calculate(String s) {
    //     int len = s.length(), sign = 1, result = 0;
    //     Stack<Integer> stack = new Stack<Integer>();
    //     for (int i = 0; i < len; i++) {
    //         // Stack<Integer> st = stack;
    //         // printStack(st);
    //         // System.out.println("---------------------------------");
    //         if (Character.isDigit(s.charAt(i))) {
    //             int sum = s.charAt(i) - '0';
    //             while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
    //                 sum = sum * 10 + s.charAt(i + 1) - '0';
    //                 i++;
    //             }
    //             result += sum * sign;
    //         } else if (s.charAt(i) == '+')
    //             sign = 1;
    //         else if (s.charAt(i) == '-')
    //             sign = -1;
    //         else if (s.charAt(i) == '(') {
    //             stack.push(result);
    //             stack.push(sign);
    //             result = 0;
    //             sign = 1;
    //         } else if (s.charAt(i) == ')') {
    //             result = result * stack.pop() + stack.pop();
    //         }
    
    //     }
    //     return result;
    // }
    public static int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int sign = 1, res = 0;
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ')'){
                res = res * st.pop() + st.pop();
            }else if(s.charAt(i) == '('){
                st.push(res);
                st.push(sign);
                res = 0;
                sign = 1;
            }else if(s.charAt(i) == '+'){
                sign = 1;
            }else if(s.charAt(i) == '-'){
                sign = -1;
            }else if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i) - '0';
                while (i + 1 < len && Character.isDigit(s.charAt(i + 1))) {
                    sum = sum * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                res += sum * sign;
            }
        }

        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calculate(input));
        sc.close();
    }

}
