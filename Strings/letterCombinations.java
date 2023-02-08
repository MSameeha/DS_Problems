import java.util.*;

public class letterCombinations {
    public static List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while(ans.peek().length() != digits.length()){
            String head = ans.remove();
            String map = mapping[digits.charAt(head.length())-'0'];

            for(char word: map.toCharArray()){
                ans.addLast(head+word);
            }

        }
        return ans;
	}
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(letterCombinations(input));
        sc.close();
    }
}
