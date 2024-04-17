// Problem link: https://leetcode.com/problems/smallest-string-starting-from-leaf/description/?envType=daily-question&envId=2024-04-17

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public String smallestFromLeaf(TreeNode root) {
        //dfs, on leaf node reverse the string and compare it with the current smallest string
        StringBuilder ans = new StringBuilder();
        dfs(root, new StringBuilder(), ans);
        return ans.toString();
    }

    void dfs(TreeNode root, StringBuilder intermediate, StringBuilder ans){
        if(root == null) return;

        intermediate.append((char)('a' + root.val));
        if(root.left == null && root.right == null){
            //leaf node
            String currentString = intermediate.reverse().toString();
            
            if(ans.length() == 0 || currentString.compareTo(ans.toString()) < 0) {
                ans.setLength(0);
                ans.append(currentString);
            }
            intermediate.reverse(); //backtrack
        }

        dfs(root.left, intermediate, ans);
        dfs(root.right, intermediate, ans);

        intermediate.setLength(intermediate.length() - 1); //remove current node
    }
}