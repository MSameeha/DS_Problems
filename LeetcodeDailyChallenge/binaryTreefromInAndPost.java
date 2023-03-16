package LeetcodeDailyChallenge;

import java.util.*;


public class binaryTreefromInAndPost {
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        return build(inorder, postorder, 0, n-1, 0, n-1);
    }

    static TreeNode build(int[] inorder, int[] postorder, int inStart, int inEnd, int poStart, int poEnd){
        if(inStart > inEnd)
            return null;
        
        TreeNode node = new TreeNode(postorder[poEnd]);

        if(inStart == inEnd)
            return node;

        int inIndex = search(inorder, inStart, inEnd, node.val);
        node.left = build(inorder, postorder, inStart, inIndex-1, poStart, poStart - inStart + inIndex -1);
        node.right = build(inorder, postorder, inIndex+1, inEnd, poEnd-inEnd+inIndex, poEnd-1);

        return node;
    }

    static int search(int[] arr, int start, int end, int val){
        int i;
        for(i = start; i <= end; i++){
            if(arr[i] == val)   return i;
        }
        return i;
    }
}
