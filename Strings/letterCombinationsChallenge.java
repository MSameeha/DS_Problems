import java.util.*;

public class letterCombinationsChallenge {    
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        HashMap<Integer, String> mp = new HashMap<>();
        mp.put(0, "0");
        mp.put(1, "1");
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
        Stack<String> st = new Stack<>();
        st.push("");

        while(!st.isEmpty()){
            String s = st.pop();

            if(s.length() == (digits.length())){
                res.add(s);
                continue;
            }
            int key = digits.charAt(s.length()) - '0';
            String map = mp.get(key);
            for(char ch: map.toCharArray()){
                st.push(s+ch);
            }
        }

        return res;
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(letterCombinations(input));
        sc.close();
    }
}
