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

public class evaluateBooleanBinaryTree {
    public boolean evaluateTree(TreeNode root) {
        //if OR check the right subtree -> if it returns True then OR => True
        //else check for left subtree as well
        //if AND check the right subtree -> if it returns False then OR => False
        //else check for left subtree as well
        if(root.val == 0) return false;
        if(root.val == 1) return true;

        if(root.val == 2){
            //OR
            if(evaluateTree(root.left)){
                root.val = 1;
                return true;
            }if(evaluateTree(root.right)){
                root.val = 1;
                return true;
            }
            root.val = 0;
            return false;
        }
        else if(root.val == 3){
            //AND
            if(!evaluateTree(root.left)){
                root.val = 0;
                return false;
            }if(!evaluateTree(root.right)){
                root.val = 0;
                return false;
            }
            root.val = 1;
            return true;
        }
        return true;
    }    
}
