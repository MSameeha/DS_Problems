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

public class addOneRowToTree {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1){
            TreeNode node = new TreeNode(val);
            node.left = root;
            return node;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        depth--;
        while(depth-- > 1){
            int size = q.size();

            while(size-- > 0){
                TreeNode node = q.poll();

                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
            }
        }

        while(!q.isEmpty()){
            TreeNode node = q.poll();
            TreeNode temp = node.left;
            node.left = new TreeNode(val);
            node.left.left = temp;

            temp = node.right;
            node.right = new TreeNode(val);
            node.right.right = temp;
        }

        return root;
    }
}
