package BFS.DFS;

import java.util.*;

public class minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M' || board[click[0]][click[1]] == 'X'){
            board[click[0]][click[1]] = 'X';
            return board;
        }
        int n = board.length, m = board[0].length;
        int[][] dir = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int num = 0;
        //if revealed a mine around then change the board value to number of mines around it 
        for(int[] d : dir){
            int r = click[0] + d[0];
            int c = click[1] + d[1];

            if(r < 0 || c < 0 || r >= n || c >= m) continue;

            if(board[r][c] == 'M') num++;
        }
        if(num > 0){
            board[click[0]][click[1]] = (char) (num + '0');
            return board;
        }

        //reveal all other adjacent boards if no mine is around
        board[click[0]][click[1]] = 'B';
        for(int[] d : dir){
            int r = click[0] + d[0];
            int c = click[1] + d[1];

            if(r < 0 || c < 0 || r >= n || c >= m) continue;

            if(board[r][c] == 'E') updateBoard(board, new int[] {r,c});
        }
        return board;
    }    
}
