package Graphs;

import java.util.*;

class searchAMaze {
    
    static boolean hasPath(int[][] maze, int[] start, int[] destination){
        maze[start[0]][start[1]] = 1;
        return searchMaze(maze, start, destination);
    }

    static boolean searchMaze(int[][] maze, int[] current, int[] destination){
        if(current[0] == destination[0] && current[1] == destination[1])
            return true;

            int[] neighborIndices = new int[2], neighbor = new int[2];
            // Indices: 0->top,1->right, 2->bottom, 3->left 
            int[][] directions = { {0,1} , {1,0} , {0,-1} , {-1,0} };
            for (int[] direction : directions) {
                neighborIndices[0] = current[0] +direction[0];
                neighborIndices[1] = current[1]+direction[1];

                if (isFeasible(maze, neighborIndices)) {
                    maze[neighborIndices[0]][neighborIndices[1]] = 1;
                    if (searchMaze(maze, neighborIndices, destination)) {
                        return true;
                    }
                }
            }
            return false;
    }

    static boolean isFeasible(int[][] maze, int[] indices) {
        int x = indices[0], y = indices[1];
        return x >= 0 && x < maze.length && y >= 0 && y < maze[x].length && maze[x][y] == 0;
    }

    public static void main(String[] args) {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};

        int[] start = {0, 4};
        int[] destination = {3,2};
        System.out.println(hasPath(maze, start, destination));
    }

}