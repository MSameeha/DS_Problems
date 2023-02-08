import java.util.*;

public class differentWaysToAddParentheses {

    //if find operate = evaluate right and left 

    public static List<Integer> diffWaysToCompute(String expression) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '*' || expression.charAt(i) == '+' || expression.charAt(i) == '-'){
                String left = expression.substring(0,i);
                String right = expression.substring(i+1);

                List<Integer> a1 = diffWaysToCompute(left);
                List<Integer> a2 = diffWaysToCompute(right);

                for(int x : a1){
                    for(int y : a2){
                        if(expression.charAt(i) == '*'){
                            ans.add(x*y);
                        }else if(expression.charAt(i) == '-'){
                            ans.add(x-y);
                        }else{
                            ans.add(x+y);
                        }
                    }
                }

            }
        }
        if(ans.size() == 0){
            ans.add(Integer.valueOf(expression));
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Integer> ans = diffWaysToCompute(input);
        for(int i = 0; i < ans.size(); i++){
            System.out.print(ans.get(i) + " , ");
        }
        sc.close();
    }
}
