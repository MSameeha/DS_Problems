package BinaryTrees;

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

public class sameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p.val != q.val){
            return false;
        }
        boolean left = true, right = true;
        if(p.left != null && q.left != null){
            left = isSameTree(p.left, q.left);
        }else if(p.left != null){
            return false;
        }else if(q.left != null){
            return false;
        }
        if(p.right != null && q.right != null){
            right = isSameTree(p.right, q.right);
        }else if(p.left != null){
            return false;
        }else if(q.left != null){
            return false;
        }

        return left && right;
    }    
}
