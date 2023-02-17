import java.util.*;

public class numberOfPeopleAwareOfSecrets {
    //
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] peopleWhoFoundSecretOnDay = new long[n+1];
        long mod = (long) 1e9 + 7;
        long numberOfPeopleGoingToShare = 0;
        peopleWhoFoundSecretOnDay[1] = 1;

        for(int i = 2; i <= n; i++){
            peopleWhoFoundSecretOnDay[i] = numberOfPeopleGoingToShare = (numberOfPeopleGoingToShare + peopleWhoFoundSecretOnDay[Math.max(i-delay, 0)] - peopleWhoFoundSecretOnDay[Math.max(i-forget, 0)] + mod) % mod;
        }
        int cnt = 0;
        for(long x : peopleWhoFoundSecretOnDay){
            System.out.println("On day " + cnt + "  -> Number of people getting to know  = " + x);
            cnt++;
        }
        long res = 0;
        for(int i = n - forget + 1; i <= n; i++){
            res = (res + peopleWhoFoundSecretOnDay[i] + mod) % mod;
        }
        return (int)res;
    }
        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int delay = sc.nextInt();
        int forget = sc.nextInt();
        System.out.println(peopleAwareOfSecret(n, delay, forget));
        sc.close();
    }
    
}
