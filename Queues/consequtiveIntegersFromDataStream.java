package Queues;

import java.util.*;

class DataStream {

    int streak, value, k;
    
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        this.streak = 0;
    }
    
    public boolean consec(int num) {
        this.streak = (num == value)? this.streak+1 : 0;

        return streak >= k;
    }
}


public class consequtiveIntegersFromDataStream {
    
}
