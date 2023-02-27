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

class Node{
    int val;
    Node next;
    Node() {}
    Node(int val){
        this.val = val;
        this.next = null;
    }
}

public class linkedlistFromBinaryTree {

    static Node convertHead(TreeNode root){

        List<Integer> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            ans = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0){
                TreeNode tempNode = queue.poll();
                
                ans.add(tempNode.val);
    
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
    
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }

        Node head = new Node(ans.get(0)), dummy = new Node();
        dummy.next = head;

        int size = ans.size()-1, i = 1;
        while(size-- > 0){
            // System.out.println(ans.get(i));
            head.next = new Node(ans.get(i));
            head = head.next;
            i++;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(5); 

        Node head = convertHead(tree);

        while(head != null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
