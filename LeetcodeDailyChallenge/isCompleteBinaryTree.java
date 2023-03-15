package LeetcodeDailyChallenge;

import java.util.*;

public class isCompleteBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        return dfs(root) >= 0;
    }
    static int dfs(TreeNode root){
        if(root == null) return 0;

        int l = dfs(root.left), r = dfs(root.right);
        if((l & (l+1)) == 0 && l/2 <= r && r <= l){
            return l+r+1;
        }
        if((r & (r+1)) == 0 && r <= l && l <= r*2+1){
            return l+r+1;
        }

        return -1;
    }
}
