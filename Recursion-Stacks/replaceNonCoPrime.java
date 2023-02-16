import java.util.*;

public class replaceNonCoPrime {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        LinkedList<Integer> res = new LinkedList<>();

        for(int a: nums){
            while(true){
                int x = res.isEmpty()? 1 : res.getLast();
                int y = gcd(x, a);
                if(y == 1) break;
                a *= (res.removeLast()) / y;
            }
            res.add(a);
        }

        return res;
    }

    int gcd(int a, int b){
        return (b > 0)? gcd(b, a % b) : a;
    }
}
