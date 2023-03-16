import java.util.*;

class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

public class buildTreeFromraversalData {
        static Node root;
        static int preIndex = 0;
        
        static Node buildTree(int pre[], int in[], int inStart, int inEnd){
            if(inStart > inEnd){
                return null;
            }
    
            Node node = new Node(pre[preIndex++]);
    
            if(inStart == inEnd){
                return node;
            }
    
            int inIndex = search(in, inStart, inEnd, node.data);
    
            node.left = buildTree(pre, in, inStart, inIndex+1);
            node.right = buildTree(pre, in, inIndex+1, inEnd);
    
            return node;
        }
        
        static int search(int in[], int start, int end, int value){
            int i;
            for(i = start; i <= end; i++){
                if(in[i] == value) return i;
            }
            return i;
        }
        
        public static Node buildTree(int in[], int pre[], int n){
            root = buildTree(pre, in, 0, n - 1);
            return root;
        }
}
