import java.util.*;

public class template {
    public static void printStack(Stack<Integer> stack) {

        // Method 1:
        String values = Arrays.toString(stack.toArray());
        System.out.println(values);
    
        // // Method 2:
        // Object[] vals = stack.toArray();
        // for (Object obj : vals) {
        //     System.out.println(obj);
        // }
    }
    public static int lengthOfLongestSubstring(String s) {
        // HashMap <char, int> frequency = new HashMap <char, int>();
        int ans = 0;

        return ans;
    }
    // ---------------------------------------------------------------------------
    //INPUT ONE STRING
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(input));
        sc.close();
    }
    // ---------------------------------------------------------------------------
    //INPUT TWO INTEGERS
    // public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // double x = sc.nextDouble();
        // int n = sc.nextInt();
        // System.out.println(myPow(x, n));
        // sc.close();
    // }
    // // ------------------------------------------------------------------------------
    // Input 2d matrix

    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int m = sc.nextInt();
    //     char[][] mat = new char[n][m];
    //     for(int i = 0; i < n; i++){
    //         for(int j = 0; j < m; j++){
    //             mat[i][j] = sc.next().charAt(0);
    //         }
    //     }
    //     System.out.println(isValidSudoku(mat));
    //     sc.close();
    // }
    // -----------------------------------------------------------------------------------
    // Input 1d int Array
    // public static void main(String[] args){
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     int[] arr = new int[n];
    //     for(int i = 0; i < n; i++){
    //         arr[i] = sc.nextInt();
    //     }
    //     System.out.println(maximumSum(arr));
    //     sc.close();
    // }
    // --------------------------------------------------------------------------------------
    //LINKED LIST INPUT AND OUTPUT
    // class ListNode {
    //     int val;
    //     ListNode next;
    //     ListNode() {}
    //     ListNode(int val) { this.val = val; }
    //     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    // }
    // public static void main(String[] args){
    //     ListNode head = new ListNode(10);
    //     head.next = new ListNode(20);
    //     head.next.next = new ListNode(30);
    //     head.next.next.next = new ListNode(40);
    //     head.next.next.next.next = new ListNode(50);
    
    //     Scanner sc = new Scanner(System.in);
    //     int n = sc.nextInt();
    //     ListNode headNew = removeNthFromEnd(head, n);

    //     while(headNew != null){
    //         System.out.print(headNew.val + " ");
    //         headNew = headNew.next;
    //     }System.out.println();
    // }
    // ---------------------------------------------------------------------------------------------
}






























// package Queues;

// import java.util.*;

// class MyCircularDeque {

//     int size;
//     int[] data;
//     int rear, front;

//     public MyCircularDeque(int k) {
//         data = new int[k];
//         size = 0;
//         rear = k-1;
//         front = 0;
//     }
    
//     public boolean insertFront(int value) {
//         if(data.length == size) return false;
//         data[front] = value;
//         front = (front + 1) % data.length;
//         size++;
//         return true;
//     }
    
//     public boolean insertLast(int value) {
//         if(data.length == size) return false;
//         data[rear] = value;
//         rear = (rear - 1 + data.length) % data.length;
//         size++;
//         return true;
//     }
    
//     public boolean deleteFront() {
        
//     }
    
//     public boolean deleteLast() {
        
//     }
    
//     public int getFront() {
//         if(size == 0) return -1;
//         return data[(front - 1 + data.length) % data.length];
//     }
    
//     public int getRear() {
//         if(size == 0) return -1;
//         return data[()]
//     }
    
//     public boolean isEmpty() {
        
//     }
    
//     public boolean isFull() {
        
//     }
// }

// public class designCircularDeque {
    
// }
