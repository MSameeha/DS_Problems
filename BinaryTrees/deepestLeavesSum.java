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

public class deepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        Queue <TreeNode> q = new ArrayDeque<>();
        int sum = 0;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size(); sum = 0;
            while(size > 0){
                root = q.poll();
                sum += root.val;
                if(root.left != null) q.add(root.left);
                if(root.right != null) q.add(root.right);
                size--;
            }
        }
        return sum;
    }
}
