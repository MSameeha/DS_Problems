package Graphs;

import java.util.*;

public class chessAndKnight {

    class Node{
        int[] pos;
        int dist;
    
        Node(int[] arr, int dist){
            this.pos = arr;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] src = new int[2];
        int[] dest = new int[2];
        src[0] = sc.nextInt();
        src[1] = sc.nextInt();
        dest[0] = sc.nextInt();
        dest[1] = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();
        chessAndKnight object = new chessAndKnight();
        Node n = object.new Node(src, 0);
        queue.add(n);

        boolean[][] visited = new boolean[9][9];

        for (int i = 1; i <= 8; i++)
		    for (int j = 1; j <= 8; j++)
			    visited[i][j] = false;

        visited[src[0]][src[1]] = true;
 
        int[] row = {2, 2, -2, -2, 1, 1, -1, -1};
        int[] col = {-1, 1, 1, -1, 2, -2, 2, -2};

        while(!queue.isEmpty()){
            n = queue.poll();

            if(n.pos[0] == dest[0] && n.pos[1] == dest[1]){
                System.out.println("The distance is " + n.dist);
                break;
            }

            for(int i = 0; i < 8; i++){
                int x = row[i], y = col[i];
                if(n.pos[0] + x > 0 && n.pos[0] + x <= 8 && n.pos[1] + y > 0 && n.pos[1] + y <= 8 && !visited[n.pos[0]+x][n.pos[1]+y]){
                    Node curr = object.new Node(new int[] {n.pos[0]+x, n.pos[1]+y}, n.dist+1);
                    queue.add(curr);
                    visited[n.pos[0]+x][n.pos[1]+y] = true;
                }
            }
        }
    }
}
