package BinaryTrees;

import java.util.*;

// Given two nodes in a binary tree, design a algorithm that computes their LCA. Assume each node has a parent pointer.



public class findLCA {
    static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode parent = null;
        TreeNode(int val) {
            this.val = val;
        }
    }
    static TreeNode findLCA(TreeNode node1, TreeNode node2){
        HashSet<TreeNode> visited = new HashSet<>();

        while(node1 != null){
            visited.add(node1);
            node1 = node1.parent;
        }

        while(node2 != null){
            if(visited.contains(node2)){
                return node2;
            }
            visited.add(node2);
            node2 = node2.parent;
        }

        return null;
    }

    public static void main(String[] args){

        TreeNode root = new TreeNode(3);
        // root.parent = null;
        root.left = new TreeNode(1);
        root.left.parent = root;
        root.right = new TreeNode(5);
        root.right.parent = root.right;
        root.right.right = new TreeNode(6);
        root.right.right.parent = root.right.right;
        root.right.left = new TreeNode(2);
        root.right.left.parent = root.right.left;

        // TreeNode root = new TreeNode(3);
        // root.right = new TreeNode(root, 5);
        // root.left = new TreeNode(root, 1);
        // root.right.right = new TreeNode(root.right, 6);
        // root.right.left = new TreeNode(root.right, 2);
        // root.right.left.right = new TreeNode(root.right.left, 7);
        // root.right.left.left = new TreeNode(root.right.left, 4);
        // root.left.right = new TreeNode(root.left, 0);
        // root.left.left = new TreeNode(root.left, 8);

        System.out.println(findLCA(root.left, root.right.right).val); 
    }
}
