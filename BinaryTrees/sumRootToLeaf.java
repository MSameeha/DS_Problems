package BinaryTrees;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        //pre order traversal

        return dfs(root, 0);
    }

    int dfs(TreeNode root, int totalSum){
        if(root == null)
            return 0;
        
        totalSum = totalSum * 10 + root.val;
        if(root.left == null && root.right == null){ //leaf node
            return totalSum;
        }

        return dfs(root.left, totalSum) + dfs(root.right, totalSum);
    }
}