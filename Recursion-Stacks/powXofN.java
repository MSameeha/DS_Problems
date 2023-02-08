import java.util.*;

public class powXofN {
    public static double rec(double x, long n){
        if(n == 0)  return 1.0;
        // if(n == 1)  return x;
        if(n < 0)   return rec(1/x, -n);

        double res = rec(x*x, n/2);

        if(n % 2 == 1){
            res *= x;
        }

        return res;
    }

    public static double myPow(double x, int n) {
        return rec(x, (long)n);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double x = sc.nextDouble();
        int n = sc.nextInt();
        System.out.println(myPow(x, n));
        sc.close();
    }
}
