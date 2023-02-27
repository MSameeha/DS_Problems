import java.util.*;

public class boundaryTraversalOfBinaryTree {
    
    static List <Integer> ans = new ArrayList<>();

    static void leftTraversal(TreeNode root){
        if(root.left != null && root.right != null)
            ans.add(root.val);

        if(root.left != null) leftTraversal(root.left);
        else leftTraversal(root.right);
    }

    static void inorder(TreeNode root){
        if(root.left == null && root.right == null)
            ans.add(root.val);
            
        inorder(root.left);
        inorder(root.right);
    }

    static void rightTraversal(TreeNode root){
        if(root.left != null && root.right != null){
            res.add(root.val);
        }
    }

    static void boundaryTraversal(TreeNode root){
        leftTraversal(root);
        inorder(root);

        List<Integer> res = new ArrayList<>();
        rightTraversal(root, res);

        for(int i = res.size()-1; i >= 1; i--){
            
        }
    }

    public static void main(String[] args) {
        
    }
}
