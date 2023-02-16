import java.util.*;

public class numberOfPeopleAwareOfSecrets {
    //
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] peopleWhoFoundSecretOnDay = new long[n+1];
        long mod = (long) 1e9 + 7;
        long numberOfPeopleGoingToShare = 0;
        peopleWhoFoundSecretOnDay[1] = 1;

        for(int i = 2; i <= n; i++){
            peopleWhoFoundSecretOnDay[i] = numberOfPeopleGoingToShare = (numberOfPeopleGoingToShare + peopleWhoFoundSecretOnDay[Math.max(i-delay, 0)] - peopleWhoFoundSecretOnDay[Math.max(i-forget, 0)] + mod) % mod;
        }
        long res = 0;
        for(int i = n - forget + 1; i <= n; i++){
            res = (res + peopleWhoFoundSecretOnDay[i] + mod) % mod;
        }
        return (int)res;
    }
    
    
}
