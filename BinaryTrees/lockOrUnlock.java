import java.util.*;

public class lockOrUnlock {

    class TreeNode {
        int val;
        boolean isLocked;
        TreeNode parent;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int val) {
            this.val = val;
            this.isLocked = false;
            this.parent = null;
            this.left = null;
            this.right = null;
        }
    }

    private TreeNode root;
    
    public lockOrUnlock(TreeNode root) {
        this.root = root;
    }
    
    public boolean isLocked(TreeNode node) {
        return node.isLocked;
    }
    
    public boolean lock(TreeNode node) {
        if (node.isLocked || isDescendantLocked(node) || hasLockedAncestor(node)) {
            return false;
        }
        
        node.isLocked = true;
        return true;
    }
    
    public boolean unlock(TreeNode node) {
        if (!node.isLocked || isDescendantLocked(node) || hasLockedAncestor(node)) {
            return false;
        }
        
        node.isLocked = false;
        return true;
    }
    
    private boolean isDescendantLocked(TreeNode node) {
        if (node.left != null && node.left.isLocked) {
            return true;
        }
        
        if (node.right != null && node.right.isLocked) {
            return true;
        }
        
        return false;
    }
    
    private boolean hasLockedAncestor(TreeNode node) {
        TreeNode current = node.parent;
        
        while (current != null) {
            if (current.isLocked) {
                return true;
            }
            
            current = current.parent;
        }
        
        return false;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.parent = root;
        root.right = new TreeNode(3);
        root.right.parent = root;
        root.left.left = new TreeNode(4);
        root.left.left.parent = root.left;
        root.left.right = new TreeNode(5);
        root.left.right.parent = root.left;
        root.right.left = new TreeNode(6);
        root.right.left.parent = root.right;
        root.right.right = new TreeNode(7);
        root.right.right.parent = root.right;
        
        lockOrUnlock tree = new lockOrUnlock(root);
        
        System.out.println(tree.lock(root)); // false
        System.out.println(tree.unlock(root)); // false
        
        System.out.println(tree.lock(root.left.left)); // true
        System.out.println(tree.lock(root.left)); // false
        System.out.println(tree.unlock(root.left.left)); // true
        System.out.println(tree.lock(root.left)); // true
    }
}
