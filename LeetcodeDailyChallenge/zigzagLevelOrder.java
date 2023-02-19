package LeetcodeDailyChallenge;

import java.util.*;

// Definition for a binary tree node.
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

public class zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer> > ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;
        while(!q.isEmpty()){
            List<Integer> l = new ArrayList<>();
            int c = q.size();

            level++;

            while(c > 0){
                TreeNode node = q.poll();
                l.add(node.val);
                if(node.left != null){
                    q.add(node.left);
                }if(node.right != null){
                    q.add(node.right);
                }
                c--;
            }
            if(level % 2 == 0){
                Collections.reverse(l);
            }
            ans.add(l);
        }
        return ans;
    }

}
