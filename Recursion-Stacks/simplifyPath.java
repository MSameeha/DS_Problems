import java.util.*;

public class simplifyPath {
    public static String simplifyPath(String path) {
        //accumulate all dots first and push to stack
            //if more than 2 dots append all together
            //if two dots find the parent directory by popping the string after a slash
            //if one dot ignore
        //accumulate all /// first and push one / to stack
        Stack<String> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        String[] p = path.split("/");

        for(int i = 0; i < p.length; i++){
            if(!s.isEmpty() && p[i].equals("..")){
                s.pop();
            }else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals("..")){
                s.push(p[i]);
            }
        }

        if(s.isEmpty()) return "/";

        while(!s.isEmpty()){
            sb.insert(0, s.pop()).insert(0, "/");
        }

        return sb.toString();

    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(simplifyPath(input));
        sc.close();
    }
}
