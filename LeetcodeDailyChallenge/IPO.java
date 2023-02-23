import java.util.*;

class Task{
    int profit;
    int capital;

    Task(int profit, int capital){
        this.profit = profit;
        this.capital = capital;
    }
}

public class IPO {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Task> pq = new PriorityQueue<>((i1, i2)->i1.capital - i2.capital);
        PriorityQueue<Task> pqCapable = new PriorityQueue<>((i1, i2)->i2.profit - i1.profit);
        for(int i = 0; i < profits.length; i++){
            pq.add(new Task(profits[i], capital[i]));
        }
        for(int i = 0; i < k; i++){
            while(!pq.isEmpty() && pq.peek().capital <= w){
                pqCapable.add(pq.poll());
            }

            if(pqCapable.isEmpty()) break;

            w += pqCapable.poll().profit;
        }
        return w;
    }
}