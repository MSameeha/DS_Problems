import java.util.*;

public class winnerOfCircularGame {
    static int cnt;
    public static int findTheWinner(int n, int k) {
        Queue <Integer> q = new LinkedList<>();
        for(int i =1; i <= n; i++){
            q.add(i);
        }
        while(q.size()!=1){
            int x = k; 
            while(x > 1){
                int r = q.peek();
                q.poll();
                q.add(r);
                x--;
            }
            q.poll();
        }
        return q.peek();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int n = sc.nextInt();
        System.out.println(findTheWinner(x, n));
        sc.close();
    }    
}
