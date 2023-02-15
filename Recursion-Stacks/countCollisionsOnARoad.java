import java.util.*;

public class countCollisionsOnARoad {
    public static int countCollisions(String directions) {
        //collide combos
        //RL -> +2
        //RS -> +1
        //LS -> +1
        //SL -> +1

        //if i car collides, it'll now become S

        int i  = 0, n = directions.length(), rightCollide = 0, ans = 0; 

        while(i < n && directions.charAt(i) == 'L') i++;

        for(; i < n; i++){
            if(directions.charAt(i) == 'R') rightCollide++;

            else{
                ans += (directions.charAt(i) == 'L')? rightCollide+1 : rightCollide;
                rightCollide = 0;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(countCollisions(input));
        sc.close();
    }
}
