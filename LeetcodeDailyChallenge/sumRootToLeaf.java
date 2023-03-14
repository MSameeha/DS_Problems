package LeetcodeDailyChallenge;

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

public class sumRootToLeaf {
    static int sum = 0;
    public static int sumNumbers(TreeNode root){
        sum = 0;
        return solve(root, 0);
    }

    static int solve(TreeNode root, int num){
        num = (num*10) + root.val;
        if(root.left == null && root.right == null){
            System.out.println(sum + " " + num + " " + root.val + " child");
            return sum+num;
        }
        if(root.left != null){
            sum = solve(root.left, num);
        }
        if(root.right != null){
            sum = solve(root.right, num);
        }
        System.out.println(sum + " " + num + " " + root.val);
        return sum;
    }
}
