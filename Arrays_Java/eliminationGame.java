import java.util.*;

public class eliminationGame {
    public static int lastRemaining(int n) {
        int res = 1;

        int rem = n, step = 1; 
        boolean left = true;
        while(rem > 1){
            if(left || rem%2 == 1){
                res = res + step;
            }
            rem = rem/2;
            step = step*2;
            left = !left;
        }

        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(lastRemaining(n));
        sc.close();
    }  
}

