import java.util.*;

public class binaryTreeFromTraversalData {
    class Node{
        int data;
        Node left;
        Node right;
    
        Node(int val){
            data = val;
            left = right = null;
        }
    }
    
    static Node root;
    static int preIndex = 0;

    Node buildTree(int pre[], int in[], int inStart, int inEnd){
        if(inStart > inEnd){
            return null;
        }

        Node node = new Node(pre[preIndex++]);

        if(inStart == inEnd){
            return node;
        }

        int inIndex = search(in, inStart, inEnd, node.data);

        node.left = buildTree(pre, in, inStart, inIndex-1);
        node.right = buildTree(pre, in, inIndex+1, inEnd);

        return node;
    }

    int search(int in[], int start, int end, int value){
        int i;
        for(i = start; i <= end; i++){
            if(in[i] == value) return i;
        }
        return i;
    }

    void printInorder(Node node)
    {
        if (node == null)
            return;
 
        /* first recur on left child */
        printInorder(node.left);
 
        /* then print the data of node */
        System.out.print(node.data + " ");
 
        /* now recur on right child */
        printInorder(node.right);
    }
 
    // driver program to test above functions
    public static void main(String args[])
    {
        binaryTreeFromTraversalData tree = new binaryTreeFromTraversalData();
        int in[] = new int[] { 4, 2, 5, 1, 6, 3 };
        int pre[] = new int[] { 1, 2, 4, 5, 3, 6};
        int len = in.length;
        Node root = tree.buildTree(pre, in, 0, len - 1);
        // System.out.println(len);
 
        // building the tree by printing inorder traversal
        System.out.println("Inorder traversal of constructed tree is : ");
        tree.printInorder(root);
    }
}
