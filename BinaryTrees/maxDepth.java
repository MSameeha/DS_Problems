package BinaryTrees;

import java.util.*;

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

public class maxDepth {
    public static int maxDepth(TreeNode root) {
        return func(root, 0);
    }
    
    static int func(TreeNode root, int depth){
        if(root == null){
            return depth;
        }
        return Math.max(func(root.left, depth)+1, func(root.right, depth)+1);
    }
}
