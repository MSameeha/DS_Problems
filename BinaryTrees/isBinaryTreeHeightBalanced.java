package BinaryTrees;

import java.util.*;

//Check if a binary tree is height balanced or not

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class isBinaryTreeHeightBalanced {

    static boolean isBalanced(TreeNode root){
        if(root.left == null && root.right == null) return true;
        if(root.left == null || root.right == null) return false;

        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println("YES");
        sc.close();
    }
}
