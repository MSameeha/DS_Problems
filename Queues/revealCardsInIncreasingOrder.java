package Queues;
import java.util.*;

public class revealCardsInIncreasingOrder {
    public static int[] deckRevealedIncreasing(int[] deck) {
        int[] ans = new int[deck.length];
        Queue<Integer> index = new LinkedList<>();

        for(int i = 0; i < deck.length; i++){
            index.add(i);
        }

        Arrays.sort(deck);

        // System.out.println("Deck elements are - ");
        // for(int x: deck){
        //     System.out.print(x + " ");
        // }System.out.println();

        for(int i = 0; i < deck.length; i++){
            ans[index.poll()] = deck[i];
            index.add(index.poll());
        }

        return ans;
    }
    // Input 1d int Array
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] ans = (deckRevealedIncreasing(arr));
        for(int x: ans){
            System.out.print(x + " ");
        }System.out.println();
        sc.close();
    }    
    
}
