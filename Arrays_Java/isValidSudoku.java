import java.util.*;

public class isValidSudoku {

    public static boolean isValidSudoku(char[][] board) {

        Set visited = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    continue;
                }
                if(!visited.add("Row " + i + board[i][j]) || !visited.add("Col " + j + board[i][j]) || !visited.add("Block " + i/3 + " " + j/3 + board[i][j])){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] mat = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(isValidSudoku(mat));
        sc.close();
    }
}
