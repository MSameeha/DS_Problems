package LinkedLists;

import java.util.*;

public class minAndMaxNumberOfNodes {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] nums = new int[2];
        nums[0] = -1;
        nums[1] = -1;
        if(head == null || head.next == null || head.next.next == null){
            return nums;
        }
        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;
        int cnt = 0;
        List<Integer> ans = new ArrayList<>();

        while(next != null){
            if((curr.val > prev.val && curr.val > next.val) || (curr.val < prev.val && curr.val < next.val)){
                ans.add(cnt);
            }
            cnt++;
            prev = curr;
            curr = next;
            next = next.next;
        }

        if(ans.size() < 2){
            return nums;
        }
        int min_d = Integer.MAX_VALUE;
        for(int i = 1; i < ans.size(); i++){
            min_d = Math.min(min_d, ans.get(i)-ans.get(i-1));
        }
        nums[0] = min_d;
        nums[1] = ans.get(ans.size()-1) - abs.get(0);
        return nums;
    }    
}
