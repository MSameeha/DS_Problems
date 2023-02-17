package LeetcodeDailyChallenge;

import java.util.*;

// Definition for a binary tree node.
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

public class minDistanceBetweenBSTNodes {
    public int minDiffInBST(TreeNode root) {
        //since BST min difference will be parent-left or right-parent
        List <Integer> inorder = new ArrayList<>();
        inorder = inorderTraversal(root, inorder);
        int n = inorder.size(), ans = Integer.MAX_VALUE;
        for(int i = 1; i < n; i++){
            ans = Math.min(ans, inorder.get(i) - inorder.get(i-1));
        }
        return ans;
    }
    static List<Integer> inorderTraversal(TreeNode root, List<Integer> inorder){
        if(root == null){
            return inorder;
        }
        inorderTraversal(root.left, inorder);
        inorder.add(root.val);
        inorderTraversal(root.right, inorder);
        return inorder;
    }
}
