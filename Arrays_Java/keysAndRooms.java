import java.util.*;

public class keysAndRooms {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        dfs(visited, rooms, 0);

        boolean ans = true;
        for(boolean b : visited){
            ans = ans && b;
        }
        return ans;
    }   

    static void dfs(boolean[] visited, List<List<Integer>> rooms, int i){
        System.out.println(i);
        visited[i] = true;
        List<Integer> ls = rooms.get(i);
        if(ls.size() == 0)
            return;
        for(int in = 0; in < rooms.get(i).size(); in++){
            dfs(visited, rooms, ls.get(in));
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int m = sc.nextInt();
            List<Integer> ls = new ArrayList<>();
            while(m-- > 0){
                ls.add(sc.nextInt());
            }
            list.add(ls);
        }
        System.out.println(canVisitAllRooms(list));
        sc.close();
    }
}
