package HashMaps;

import java.util.*;

public class findingUsersActiveMinutes {

    public static int[] findingUsersActiveMinutes(int[][] logs, int k) {
        //hashmap of integer and set 
        HashMap<Integer, Set<Integer> > map = new HashMap<>();

        //another map storing size of set of map as key and value as freq 
        HashMap<Integer, Integer> freq = new HashMap<>();

        int n = logs.length;
        for(int i = 0; i < n; i++){
            Set<Integer> se = new HashSet<>();
            if(map.containsKey(logs[i][0])){
                se = map.get(logs[i][0]);
            }
            se.add(logs[i][1]);
            map.put(logs[i][0], se);
        }

        // for(int i = 0; i < n; i++){
        //     System.out.print("User ID " + logs[i][0] + " ->  ");
        //     Iterator itr = map.get(logs[i][0]).iterator();
 
        //     // check element is present or not. if not loop will
        //     // break.
        //     while (itr.hasNext()) {
        //         System.out.print(itr.next() + " ");
        //     }System.out.println("----------------------------");
        // }
        // System.out.println(map.size());
        // System.out.println("-------------------------------DEBUG-----------------------------------");

        int[] ans = new int[k];
        for(int id : map.keySet()){
            int UAM = map.get(id).size();
            ans[UAM-1]++;
        }

        return ans;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = 2;
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int[] ans = findingUsersActiveMinutes(mat, k);
        for(int i = 0; i < ans.length; i++){
            System.out.print(ans[i] + " ");
        }System.out.println();
        sc.close();
    }
    
}
