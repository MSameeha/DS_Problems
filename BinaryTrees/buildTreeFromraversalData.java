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

public class buildTreeFromraversalData {
    static int preIndex = 0;

    static TreeNode buildTree(int[] pre, int[] in, int start, int end){
        if(start > end) return null;

        TreeNode node = new TreeNode(pre[preIndex++]);

        if(start == end) return node;

        int index = 
    }
}
