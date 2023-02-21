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

public class createBinaryTreeFromDescription {
    public static TreeNode createBinaryTree(int[][] descriptions) {
        //value and node hashmap
        HashMap <Integer, TreeNode> val_node = new HashMap<>();
        int n = descriptions.length;
        Set<Integer> child = new HashSet<>();

        for(int i = 0; i < n; i++){
            TreeNode node = val_node.getOrDefault(descriptions[i][0], new TreeNode(descriptions[i][0]));
            if(descriptions[i][2] == 1){
                //left
                node.left = val_node.getOrDefault(descriptions[i][1], new TreeNode(descriptions[i][1]));
                val_node.put(descriptions[i][1], node.left);
                child.add(descriptions[i][1]);
            }else{
                node.right = val_node.getOrDefault(descriptions[i][1], new TreeNode(descriptions[i][1]));
                val_node.put(descriptions[i][1], node.right);
                child.add(descriptions[i][1]);
            }
            val_node.put(descriptions[i][0], node);
        }
        int root = -1;
        for(int[] arr: descriptions){
            if(!child.contains(arr[0])){
                root = arr[0];
                break;
            }
        }
        return val_node.get(root);
    }

        public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(createBinaryTree(mat));
        sc.close();
    }
}
