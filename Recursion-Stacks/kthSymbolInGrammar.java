import java.util.*;

public class kthSymbolInGrammar {

    public static int solve(int n, int k){

        if(n == 0){
            return 0;
        }

        if(k <= (n/2)){
            return solve(n-1, k);
        }else{
            int x = solve(n-1, k - (n/2));
            if(x == 0) return 1;
            return 0;
            // return ~solve(n-1, k - (n/2));
        }
    }

    public static int kthGrammar(int n, int k) {
        return solve(n, k);
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(kthGrammar(x, n));
        sc.close();
    }
}
